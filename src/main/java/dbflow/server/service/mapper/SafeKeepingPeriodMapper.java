package dbflow.server.service.mapper;


import dbflow.server.domain.*;
import dbflow.server.service.dto.SafeKeepingPeriodDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SafeKeepingPeriod} and its DTO {@link SafeKeepingPeriodDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SafeKeepingPeriodMapper extends EntityMapper<SafeKeepingPeriodDTO, SafeKeepingPeriod> {



    default SafeKeepingPeriod fromId(Long id) {
        if (id == null) {
            return null;
        }
        SafeKeepingPeriod safeKeepingPeriod = new SafeKeepingPeriod();
        safeKeepingPeriod.setId(id);
        return safeKeepingPeriod;
    }
}
