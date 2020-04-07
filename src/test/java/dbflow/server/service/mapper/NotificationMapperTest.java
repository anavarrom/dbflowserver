package dbflow.server.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationMapperTest {

    private NotificationMapper notificationMapper;

    @BeforeEach
    public void setUp() {
        notificationMapper = Mappers.getMapper( NotificationMapper.class );
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(notificationMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(notificationMapper.fromId(null)).isNull();
    }
}
