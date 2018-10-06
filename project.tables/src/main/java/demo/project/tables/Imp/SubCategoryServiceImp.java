package demo.project.tables.Imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.SubCategoryService;
import demo.project.tables.model.Category;
import demo.project.tables.model.SubCategory;

@Component
@Transactional
public class SubCategoryServiceImp implements SubCategoryService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public SubCategory getSubCategory(int subc_id) {
		
		
		try 
		{
			SubCategory subCategory=sessionFactory.getCurrentSession().get(SubCategory.class,subc_id);
			return subCategory;
			
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	
	@Override
	public List<SubCategory> getSubCategoryList(int c_id) 
	{
		try
		{
			Query<SubCategory> query=sessionFactory.getCurrentSession().createQuery("From SubCategory where category_c_id=:id", SubCategory.class);
					query.setParameter("id", c_id);
			return query.getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SubCategory> getAllSubCategoryList() {
		try {
            return sessionFactory.getCurrentSession().createCriteria(SubCategory.class).list();
        } catch (Exception e) {
            return null;
        }
	}

	@Override
	public List<SubCategory> getElectronics() {
		try {
            Query<SubCategory> query = sessionFactory.getCurrentSession()
                    .createQuery("from SubCategory where category_c_id=1", SubCategory.class);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
	}

}
