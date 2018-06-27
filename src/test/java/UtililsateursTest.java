
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.jdr.dao.UtilisateurDaoImpl;
import com.jdr.entity.Utilisateur;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback()
public class UtililsateursTest {

	/*@Autowired
	UtilisateurDaoImpl userDao;
	
	Log log = LogFactory.getLog(Utilisateur.class);
	long idTested;
	
	@Before
	public void before() {
		Utilisateur u = new Utilisateur("jdfkqj@hotmail.fr","jjjjj", "kkkk", "1234");
		Utilisateur u1 = new Utilisateur("aaaaaa@hotmail.fr","aaaa", "vvvvv", "0000");
		Utilisateur u2 = new Utilisateur("bbbbbb@hotmail.fr","bbbbb", "bbb", "123");

		
		ExtendedProperties ecten = new ExtendedProperties();
		ecten.setLibelle("Begles A NICE CITY");
		ecten.setDescription("IT IZ A GOOD CITY");
		ecten.setSmallDesc("Begles in english baby");
		c.getCommonFields().put(I18nLang.EN,ecten);
		
		ExtendedProperties ectfr = new ExtendedProperties();
		
		ectfr.setLibelle("Begles c'est cool");
		ectfr.setDescription("Begles yep");
		ectfr.setSmallDesc("begles en francais baby");
		c.getCommonFields().put(I18nLang.FR,ectfr);
		this.idTested = c.getId();
		
		this.log.info("Creation of 3 entities City and 2 countries");		
	}
	
	@Test
	public void testUtilisateur() {
		Assert.assertTrue(this.userDao.findAll().iterator().hasNext());
		Assert.assertTrue(this.userDao.count() == 3);
	}
	
	@Test
	public void testCountLanguagesView() {
		City c = this.cr.findById(this.idTested).get();	
		Assert.assertTrue("Testing to get 2 translation. getting: "+c.getCommonFields().size(),c.getCommonFields().size() == 2);
	}
	
	@Test
	public void testUtilisateurUpdate() {
		City c = this.cr.findAll().iterator().next();	
		c.setPostcode("64000");
		this.cr.save(c);
		c = this.cr.findById(c.getId()).get();
		Assert.assertTrue(c.getPostcode().equals("64000"));
	}
	
	@Test
	public void testAddUtilisateur() {
		
		City cdeux = this.cr.findAll().iterator().next();	
		cdeux.setPostcode("JPN");
		ExtendedProperties ectth = new ExtendedProperties();
		ectth.setLibelle("BEGLES DEEEEEEE");
		ectth.setDescription("Begles Dee mhak mhak");
		ectth.setSmallDesc("jing jing, begles");
		int currentSize = cdeux.getCommonFields().size();
		
		cdeux.getCommonFields().put(I18nLang.TH,ectth);
		this.cr.save(cdeux);
		cdeux = this.cr.findById(cdeux.getId()).get();
		Assert.assertTrue("Testing there is "+ ( currentSize + 1 ) +" languages: found "+cdeux.getCommonFields().size() ,cdeux.getCommonFields().size() == currentSize + 1);
	}
	
	@Test
	public void testRemoveUtilisateur() {
		Utilisateur u = this.userDao.findAll().iterator().next();	
		u.getId().remove(u.getId().keySet().iterator().next());
		this.userDao.save(c);
		u = this.userDao.findAll().iterator().next();
		Assert.assertTrue(u.getId().size() == 1);
	}
	
	@Test
	public void testDelete() {
		Utilisateur u = this.userDao.findAll().iterator().next();	
		long id = u.getId();
		
		this.userDao.delete(u);	
		Assert.assertFalse(userDao.findByPrimaryKey(id).isPresent());
	}*/

}