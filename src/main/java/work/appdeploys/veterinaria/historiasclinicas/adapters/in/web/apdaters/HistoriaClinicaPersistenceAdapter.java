package work.appdeploys.veterinaria.historiasclinicas.adapters.in.web.apdaters;

import work.appdeploys.veterinaria.constans.MessageResource;
import work.appdeploys.veterinaria.exceptions.HistoriaClinicaExeptionBadRequest;
import work.appdeploys.veterinaria.historiasclinicas.adapters.out.persistence.entity.HistoriaClinicaEntity;
import work.appdeploys.veterinaria.historiasclinicas.adapters.out.persistence.mapper.HistoriaClinicaOutMapper;
import work.appdeploys.veterinaria.historiasclinicas.adapters.out.persistence.repository.HistoriaClinicaOutRepository;
import work.appdeploys.veterinaria.historiasclinicas.application.port.in.HistoriaClinicaCommand;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaDeletePort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaFindAllByIdMascotaPort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaFindAllPort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaFindByIdMascotaPort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaFindByIdPort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaSavePort;
import work.appdeploys.veterinaria.historiasclinicas.application.port.out.HistoriaClinicaUpdatePort;
import work.appdeploys.veterinaria.historiasclinicas.common.PersistenceAdapter;
import work.appdeploys.veterinaria.historiasclinicas.domain.HistoriaClinica;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
public class HistoriaClinicaPersistenceAdapter implements HistoriaClinicaDeletePort,
        HistoriaClinicaFindAllPort,
        HistoriaClinicaFindByIdPort,
        HistoriaClinicaSavePort,
        HistoriaClinicaUpdatePort,
        HistoriaClinicaFindByIdMascotaPort,
        HistoriaClinicaFindAllByIdMascotaPort {

    HistoriaClinicaOutRepository historiaClinicaOutRepository;
    HistoriaClinicaOutMapper historiaClinicaOutMapper;

    public HistoriaClinicaPersistenceAdapter(HistoriaClinicaOutRepository historiaClinicaOutRepository, HistoriaClinicaOutMapper historiaClinicaOutMapper) {
        this.historiaClinicaOutRepository = historiaClinicaOutRepository;
        this.historiaClinicaOutMapper = historiaClinicaOutMapper;
    }

    @Override
    public boolean delete(Long id) {
        try{
            historiaClinicaOutRepository.deleteById(id);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public List<HistoriaClinica> findAll() {
        List<HistoriaClinicaEntity> listHistoriaClinicaEntity = historiaClinicaOutRepository.findAll();
        if(listHistoriaClinicaEntity.isEmpty()){
            throw new HistoriaClinicaExeptionBadRequest(MessageResource.HISTORIA_CLINICA_NOT_FOUND.getValue());
        }
        return listHistoriaClinicaEntity.stream().map(historiaClinicaOutMapper::toDomainModel).collect(Collectors.toList());
    }

    //TODO no se como validar teniendo la capa adicional revisar con victor me toco cambiar esto aun optional
    @Override
    public Optional<HistoriaClinica> findById(Long id) {
           HistoriaClinicaEntity historiaClinicaEntity = historiaClinicaOutRepository
                .findById(id)
                .orElseThrow(() ->new HistoriaClinicaExeptionBadRequest(MessageResource.HISTORIA_CLINICA_NOT_FOUND.getValue()));

        return Optional.ofNullable(historiaClinicaOutMapper.toDomainModel(historiaClinicaEntity));
    }
    @Override
    public HistoriaClinica save(HistoriaClinicaCommand historiaClinicaCommand) {
        return historiaClinicaOutMapper.toDomainModel(historiaClinicaOutRepository.save(historiaClinicaOutMapper.toEntity(historiaClinicaCommand)));
    }
    @Override
    public HistoriaClinica update(HistoriaClinica historiaClinica) {
        return historiaClinicaOutMapper.toDomainModel(historiaClinicaOutRepository.save(historiaClinicaOutMapper.toEntity(historiaClinica)));
    }

    @Override
    public Optional<HistoriaClinica> findByMascota_Id(Long id) {
        Optional<HistoriaClinicaEntity> optHistoriaClinicaEntity = historiaClinicaOutRepository.findByMascota_Id(id);
        if(optHistoriaClinicaEntity.isPresent()){
            HistoriaClinica historiaClinica = historiaClinicaOutMapper.toDomainModel(optHistoriaClinicaEntity.get());
            return Optional.ofNullable(historiaClinica);
        }

        throw new HistoriaClinicaExeptionBadRequest(MessageResource.MASCOTAS_NOT_FOUND.getValue());
    }

    @Override
    public List<HistoriaClinica> findAllByMascota_Id(Long id) {
        List<HistoriaClinicaEntity> listHistoriaClinicaEntity = historiaClinicaOutRepository.findAllByMascota_Id(id);
        return  listHistoriaClinicaEntity.stream().map(historiaClinicaOutMapper::toDomainModel).collect(Collectors.toList());
    }
}
