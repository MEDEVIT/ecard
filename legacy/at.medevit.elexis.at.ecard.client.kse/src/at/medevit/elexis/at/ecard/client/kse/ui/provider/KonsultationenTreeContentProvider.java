package at.medevit.elexis.at.ecard.client.kse.ui.provider;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;
import org.eclipse.persistence.jpa.JpaEntityManager;

import at.medevit.elexis.at.ecard.client.kse.entitymanager.EntityManagerService;
import at.medevit.elexis.at.ecard.client.kse.model.annotated.Konsultationsbeleg;

public class KonsultationenTreeContentProvider implements ITreeContentProvider {
	
	private static EntityManager em = EntityManagerService.getEntityManager();
	private static ExpressionBuilder emp = new ExpressionBuilder();
	private static JpaEntityManager jpaEm = (JpaEntityManager) em;
	
	public KonsultationenTreeContentProvider(TreeViewer treeViewer){
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void dispose(){
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput){
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Object[] getElements(Object inputElement){
		Query q = null;
		if (inputElement == "0") {
			q =
				em.createQuery("SELECT DISTINCT k.abrechnungsPeriode FROM Konsultationsbeleg k ORDER BY k.abrechnungsPeriode DESC",
					String.class);
		} else {
			q =
				em.createQuery(
					"SELECT DISTINCT k.abrechnungsPeriode FROM Konsultationsbeleg k WHERE k.svNummer = :svnr",
					String.class);
			q.setParameter("svnr", inputElement);
		}
		List<String> res = q.getResultList();
		return res.toArray(new String[] {});
	}
	
	@Override
	public Object[] getChildren(Object parentElement){
		String periode = (String) parentElement;
		Expression e = emp.get("abrechnungsPeriode").equal(periode);
		Query q = jpaEm.createQuery(e, Konsultationsbeleg.class);
		List<Konsultationsbeleg> lkb = q.getResultList();
		return lkb.toArray(new Konsultationsbeleg[] {});
	}
	
	@Override
	public Object getParent(Object element){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean hasChildren(Object element){
		if (element.getClass().equals(String.class)) {
			// TODO: Richtige reihenfole ORDER BY
			Query q =
				em.createQuery("SELECT k FROM Konsultationsbeleg k WHERE k.abrechnungsPeriode = :periode ORDER BY k.behandlungsDatum ASC");
			q.setParameter("periode", element + "");
			// TODO select count?
			if (q.getResultList().size() > 0)
				return true;
		}
		return false;
	}
}
