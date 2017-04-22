package colloques.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import colloques.classesMetier.Evenement;
import colloques.classesMetier.Utilisateur;
import colloques.dao.ConnexionDAO;
import colloques.dao.EvenementDAO;
import colloques.utilitaire.SingletonConnexion;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author florent
 */
public class TestSuite {
    
    public static final String username = "daniel5";
    public static final String password = "toto123";

    @BeforeClass
    public static void setUpClass() throws Exception {
        SingletonConnexion.getInstance();
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testConnexion() {
        ConnexionDAO connexionDAO = new ConnexionDAO();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdentifiant(username);
        utilisateur.setPass(password);

        assertTrue("failure - should be true", connexionDAO.SeConnecter(utilisateur));
    }
    
    @Test
    public void testInsertEvent()
    {
        EvenementDAO eventDAO = new EvenementDAO();
        
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.DATE, 1);
        
        Evenement event = new Evenement(
            "testLibelle", "testTheme",
            gc, gc,
            1, 20,
            "testDescription", "testOrganisateur",
            "testTypeEvent", "À venir", 1
        );
        assertTrue("failure - should be true", eventDAO.create(event));
    }
    
    @Test
    public void testRemoveEvent() {
        EvenementDAO eventDAO = new EvenementDAO();

        for(Evenement event : eventDAO.getALL()) {
            if(event.getLibelle().equals("testLibelle"))
            {
                assertTrue("failure - should be true", eventDAO.delete(event));
                return;
            }
        }
    }
}
