package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Entity.Itinerario;



@Repository
public interface Itinerario_Repository extends JpaRepository<Itinerario, Long>{

	@Query("select m from Itinerario_Entity m where m.codigo =:codigo")
	public Itinerario findByCodigo(@Param("codigo")String codigo);

}
