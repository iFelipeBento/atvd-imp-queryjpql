package dev.fujioka.java.avancado.web.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.fujioka.java.avancado.web.domain.Product;

@Repository
public interface ProductRepository
	extends JpaRepository<Product, Long> {

    public List<Product> findProductByName(String name);
	@Query("SELECT p FROM Product p ORDER BY dtCreation ASC")
	public List<Product> buscarProdutosOrderByCreation();

	@Query("SELECT p.dtUpdate FROM Product p WHERE p.id = :id")
	public Date buscarDataUltimoUpdate(Long id);

	@Query("SELECT p FROM Product p WHERE p.description like %:description%")
	public List<Product> buscarPorDescricao(String description);

	@Query("SELECT p FROM Product p WHERE lower(p.description) like lower(:description)")
	public List<Product> buscarPorDescricaoIgnoreCase(String description);
	
	@Query("SELECT p FROM Product p WHERE p.id = :id")
	public Product buscarPorId(Long id);

}