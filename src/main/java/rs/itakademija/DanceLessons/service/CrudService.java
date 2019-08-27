package rs.itakademija.DanceLessons.service;

import java.util.List;

/**
 * 
 * Every single service will rely on this "main" service and will extend it.
 * Since every service will be interface, we can add more methods to them.
 * Those services will be implemented by their implementation classes.
 * 
 */

public interface CrudService<E, DTO> {

	/**
	 * Find and return entity with passed id.
	 * 
	 * @param id
	 *            of the entity to return
	 * @return entity with passed id or null if not found
	 */
	DTO findOne(Integer id);

	/**
	 * Return back all existing entities.
	 * 
	 * @return list of existing entities, empty list if there are no entities
	 */
	List<DTO> findAll();

	/**
	 * Save entity and return saved instance (with id set).
	 * 
	 * @param entity
	 *            to be saved
	 * @return saved instance
	 */
	DTO save(E e);

	/**
	 * Remove entity with passed id.
	 * 
	 * @param id
	 *            of the entity to be removed
	 * @throws IllegalArgumentException
	 *             if there is no entity with passed id
	 */
	void remove(Integer id) throws IllegalArgumentException;
	
	/**
	 * 
	 * Update entity with passed id and entity.
	 * 
	 * @param id and entity
	 * 				id is used to recognize which entity should be updated with the entity provided
	 * @throws IllegalArgumentException
	 * 				if there is no entity with passed id
	 */
	
	DTO update(Integer id, E e);
	
}
