package dbflow.server.service.impl;

import dbflow.server.service.SafeKeepingPeriodService;
import dbflow.server.domain.SafeKeepingPeriod;
import dbflow.server.repository.SafeKeepingPeriodRepository;
import dbflow.server.service.dto.SafeKeepingPeriodDTO;
import dbflow.server.service.mapper.SafeKeepingPeriodMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SafeKeepingPeriod}.
 */
@Service
@Transactional
public class SafeKeepingPeriodServiceImpl implements SafeKeepingPeriodService {

    private final Logger log = LoggerFactory.getLogger(SafeKeepingPeriodServiceImpl.class);

    private final SafeKeepingPeriodRepository safeKeepingPeriodRepository;

    private final SafeKeepingPeriodMapper safeKeepingPeriodMapper;

    public SafeKeepingPeriodServiceImpl(SafeKeepingPeriodRepository safeKeepingPeriodRepository, SafeKeepingPeriodMapper safeKeepingPeriodMapper) {
        this.safeKeepingPeriodRepository = safeKeepingPeriodRepository;
        this.safeKeepingPeriodMapper = safeKeepingPeriodMapper;
    }

    /**
     * Save a safeKeepingPeriod.
     *
     * @param safeKeepingPeriodDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SafeKeepingPeriodDTO save(SafeKeepingPeriodDTO safeKeepingPeriodDTO) {
        log.debug("Request to save SafeKeepingPeriod : {}", safeKeepingPeriodDTO);
        SafeKeepingPeriod safeKeepingPeriod = safeKeepingPeriodMapper.toEntity(safeKeepingPeriodDTO);
        safeKeepingPeriod = safeKeepingPeriodRepository.save(safeKeepingPeriod);
        return safeKeepingPeriodMapper.toDto(safeKeepingPeriod);
    }

    /**
     * Get all the safeKeepingPeriods.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SafeKeepingPeriodDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SafeKeepingPeriods");
        return safeKeepingPeriodRepository.findAll(pageable)
            .map(safeKeepingPeriodMapper::toDto);
    }


    /**
     * Get one safeKeepingPeriod by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SafeKeepingPeriodDTO> findOne(Long id) {
        log.debug("Request to get SafeKeepingPeriod : {}", id);
        return safeKeepingPeriodRepository.findById(id)
            .map(safeKeepingPeriodMapper::toDto);
    }

    /**
     * Delete the safeKeepingPeriod by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SafeKeepingPeriod : {}", id);
        safeKeepingPeriodRepository.deleteById(id);
    }
}
