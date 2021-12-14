package org.ovirt.engine.core.dao;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.compat.Guid;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@Singleton
public class WhitelistDaoImpl extends BaseDao implements WhitelistDao {

    private static final Logger log = LoggerFactory.getLogger(WhitelistDaoImpl.class);

    private static final RowMapper<Whitelist> whitelistRowMapper = (rs, rowNum) -> {
        Whitelist entity = new Whitelist();
        entity.setId(getGuidDefaultEmpty(rs, "whitelist_id"));
        entity.setId(getGuidDefaultEmpty(rs, "description"));
        entity.setId(getGuidDefaultEmpty(rs, "user_name"));
        entity.setId(getGuidDefaultEmpty(rs, "ip_address"));
        entity.setId(getGuidDefaultEmpty(rs, "registration_time"));
        return entity;
    };

    // FIXME: need to create whitelists_view, create_views.sql 
    /*
    @Override
    public Whitelist get(Guid id) {
        MapSqlParameterSource parameterSource = getCustomMapSqlParameterSource()
            .addValue("whitelist_id", id);

        return getCallsHandler().executeRead("GetWhitelistByWhitelistId", whitelistRowMapper, parameterSource);
    }

    @Override
    public List<Whitelist> getAll() {
        MapSqlParameterSource parameterSource = getCustomMapSqlParameterSource();
        return getCallsHandler().executeReadList("GetAllFromWhitelists", whitelistRowMapper, parameterSource);
    }
    */

    private MapSqlParameterSource createIdParameterMapper(Guid id) {
        return getCustomMapSqlParameterSource().addValue("whitelist_id", id);
    }

    @Override
    public void save(Whitelist whitelist) {
        log.info("WhitelistDaoImpl save() start");
        
        getCallsHandler().executeModification("InsertWhitelist",
                createIdParameterMapper(whitelist.getId())
                        .addValue("description", whitelist.getDescription())
                        .addValue("user_name", whitelist.getUserName())
                        .addValue("ip_address", whitelist.getIpAddress())
                        .addValue("registration_time", whitelist.getRegistrationTime()));
        
        log.info("WhitelistDaoImpl save() end");
    }

    @Override
    public void update(Whitelist whitelist) {
        getCallsHandler().executeModification("UpdateWhitelist",
                createIdParameterMapper(whitelist.getId())
                        .addValue("description", whitelist.getDescription())
                        .addValue("user_name", whitelist.getUserName())
                        .addValue("ip_address", whitelist.getIpAddress())
                        .addValue("registration_time", whitelist.getRegistrationTime()));
    }

    @Override
    public void remove(Guid id) {
        MapSqlParameterSource parameterSource = createIdParameterMapper(id);

        getCallsHandler().executeModification("DeleteWhitelist", parameterSource);
    }


}
