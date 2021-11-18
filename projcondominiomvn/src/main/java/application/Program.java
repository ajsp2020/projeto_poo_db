package application;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entities.Condominio;
import model.entities.Empresa;
import model.entities.Servico;
import model.entities.Status;
import model.entities.Telefone;
import model.entities.TipoDeServico;

public class Program {

	public static void main(String[] args) {
		Telefone telefone = new Telefone();
		Empresa empresa = new Empresa();
		Status status = new Status();
		TipoDeServico tds = new TipoDeServico();
		
		
		
		
		
		
		
		Condominio cond = new Condominio(null, "michelangelo", "paulo");
		//Condominio cond2 = new Condominio(null, "Alvorada", "Rodrigo");
		//Condominio cond3 = new Condominio(null, "Sol nascente", "Ricardo");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Condominio cond = em.find(Condominio.class, 2);
		//System.out.println(cond);
		
		//em.getTransaction().begin();
		//em.remove(cond);
		//em.getTransaction().commit();
		
		em.getTransaction().begin();
		telefone = new Telefone(null, "61", "9999-9999", telefone.getEmpresa());
		em.persist(telefone);
		empresa = new Empresa(null, "BB construcoes", "11111-1111", empresa.getServico(), null);
		em.persist(empresa);
		status = new Status(null, "completado", status.getServico());
		em.persist(status);
		tds = new TipoDeServico(null, "Pintura", tds.getServico());
		em.persist(tds);
		Servico servico = new Servico(null , new Date(), 1000.0, status,empresa ,tds);
		em.persist(servico);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		System.out.println(servico);
		
		em.close();
		emf.close();
		
	}

}
