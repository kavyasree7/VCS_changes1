/*Generated by WaveMaker Studio*/
package com.faturacaomodelo.dbc4b.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.faturacaomodelo.dbc4b.Role;
import com.faturacaomodelo.dbc4b.User;

/**
 * Service object for domain model class {@link Role}.
 */
public interface RoleService {

    /**
     * Creates a new Role. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Role if any.
     *
     * @param roleInstance Details of the Role to be created; value cannot be null.
     * @return The newly created Role.
     */
	Role create(Role roleInstance);


	/**
	 * Returns Role by given id if exists.
	 *
	 * @param roleId The id of the Role to get; value cannot be null.
	 * @return Role associated with the given roleId.
     * @throws EntityNotFoundException If no Role is found.
	 */
	Role getById(Integer roleId) throws EntityNotFoundException;

    /**
	 * Find and return the Role by given id if exists, returns null otherwise.
	 *
	 * @param roleId The id of the Role to get; value cannot be null.
	 * @return Role associated with the given roleId.
	 */
	Role findById(Integer roleId);


	/**
	 * Updates the details of an existing Role. It replaces all fields of the existing Role with the given roleInstance.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Role if any.
     *
	 * @param roleInstance The details of the Role to be updated; value cannot be null.
	 * @return The updated Role.
	 * @throws EntityNotFoundException if no Role is found with given input.
	 */
	Role update(Role roleInstance) throws EntityNotFoundException;

    /**
	 * Deletes an existing Role with the given id.
	 *
	 * @param roleId The id of the Role to be deleted; value cannot be null.
	 * @return The deleted Role.
	 * @throws EntityNotFoundException if no Role found with the given id.
	 */
	Role delete(Integer roleId) throws EntityNotFoundException;

	/**
	 * Find all Roles matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Roles.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Role> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Roles matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Roles.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Role> findAll(String query, Pageable pageable);

    /**
	 * Exports all Roles matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Roles in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Role.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated users for given Role id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated User instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<User> findAssociatedUsers(Integer id, Pageable pageable);

}

