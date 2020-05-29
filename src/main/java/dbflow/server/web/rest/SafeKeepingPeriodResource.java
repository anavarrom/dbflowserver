package dbflow.server.web.rest;

import dbflow.server.domain.SafeKeepingPeriod;
import dbflow.server.repository.SafeKeepingPeriodRepository;
import dbflow.server.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link dbflow.server.domain.SafeKeepingPeriod}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SafeKeepingPeriodResource {

    private final Logger log = LoggerFactory.getLogger(SafeKeepingPeriodResource.class);

    private static final String ENTITY_NAME = "dbFlowServerSafeKeepingPeriod";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SafeKeepingPeriodRepository safeKeepingPeriodRepository;

    public SafeKeepingPeriodResource(SafeKeepingPeriodRepository safeKeepingPeriodRepository) {
        this.safeKeepingPeriodRepository = safeKeepingPeriodRepository;
    }

    /**
     * {@code POST  /safe-keeping-periods} : Create a new safeKeepingPeriod.
     *
     * @param safeKeepingPeriod the safeKeepingPeriod to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new safeKeepingPeriod, or with status {@code 400 (Bad Request)} if the safeKeepingPeriod has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/safe-keeping-periods")
    public ResponseEntity<SafeKeepingPeriod> createSafeKeepingPeriod(@RequestBody SafeKeepingPeriod safeKeepingPeriod) throws URISyntaxException {
        log.debug("REST request to save SafeKeepingPeriod : {}", safeKeepingPeriod);
        if (safeKeepingPeriod.getId() != null) {
            throw new BadRequestAlertException("A new safeKeepingPeriod cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SafeKeepingPeriod result = safeKeepingPeriodRepository.save(safeKeepingPeriod);
        return ResponseEntity.created(new URI("/api/safe-keeping-periods/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /safe-keeping-periods} : Updates an existing safeKeepingPeriod.
     *
     * @param safeKeepingPeriod the safeKeepingPeriod to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated safeKeepingPeriod,
     * or with status {@code 400 (Bad Request)} if the safeKeepingPeriod is not valid,
     * or with status {@code 500 (Internal Server Error)} if the safeKeepingPeriod couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/safe-keeping-periods")
    public ResponseEntity<SafeKeepingPeriod> updateSafeKeepingPeriod(@RequestBody SafeKeepingPeriod safeKeepingPeriod) throws URISyntaxException {
        log.debug("REST request to update SafeKeepingPeriod : {}", safeKeepingPeriod);
        if (safeKeepingPeriod.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SafeKeepingPeriod result = safeKeepingPeriodRepository.save(safeKeepingPeriod);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, safeKeepingPeriod.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /safe-keeping-periods} : get all the safeKeepingPeriods.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of safeKeepingPeriods in body.
     */
    @GetMapping("/safe-keeping-periods")
    public List<SafeKeepingPeriod> getAllSafeKeepingPeriods() {
        log.debug("REST request to get all SafeKeepingPeriods");
        return safeKeepingPeriodRepository.findAll();
    }

    /**
     * {@code GET  /safe-keeping-periods/:id} : get the "id" safeKeepingPeriod.
     *
     * @param id the id of the safeKeepingPeriod to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the safeKeepingPeriod, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/safe-keeping-periods/{id}")
    public ResponseEntity<SafeKeepingPeriod> getSafeKeepingPeriod(@PathVariable Long id) {
        log.debug("REST request to get SafeKeepingPeriod : {}", id);
        Optional<SafeKeepingPeriod> safeKeepingPeriod = safeKeepingPeriodRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(safeKeepingPeriod);
    }

    /**
     * {@code DELETE  /safe-keeping-periods/:id} : delete the "id" safeKeepingPeriod.
     *
     * @param id the id of the safeKeepingPeriod to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/safe-keeping-periods/{id}")
    public ResponseEntity<Void> deleteSafeKeepingPeriod(@PathVariable Long id) {
        log.debug("REST request to delete SafeKeepingPeriod : {}", id);

        safeKeepingPeriodRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
