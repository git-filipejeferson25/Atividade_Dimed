package Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import Entity.Linha;
import Service.Linha_Service;

@Repository
public interface I_Linha_Repository {


	@Query("select m from Linha m where m.codigo =:codigo")
	public Linha findByCodigo(@Param("codigo")String codigo);

	public void save(Linha_Service linhaEntityAtualizada);

	public void deleteById(Long id);

	public Object findAll();

	public Optional<Linha> findByCodigo();

	public void save(Linha linhaEntityAtualizada);

}
