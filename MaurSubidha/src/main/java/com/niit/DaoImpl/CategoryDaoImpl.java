package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;
import com.niit.model.Product;
@Repository
public class CategoryDaoImpl implements CategoryDao{
@Autowired
	private SessionFactory sessionFactory;

	public List<Category> getAllCategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> categories=query.list();
		session.close();
		return categories;
	}

	public Category getByName(String name) {
		 String hql="from Category where categoryDetails=?";
         Query query=sessionFactory.openSession().createQuery(hql);
         query.setString(0, name);
         @SuppressWarnings("unchecked")
         List<Category> listCategory=(List<Category>) query.list();
         if (listCategory != null && !listCategory.isEmpty()) {
               return listCategory.get(0);
         }
         else
         {
               return null;                 
         }

	}

	public void saveOrUpdateCategory(Category category) {
			Session session=sessionFactory.openSession();
			System.out.println("CATEGORY ID BEFORE INSERTION " + category.getCid());
			session.saveOrUpdate(category);
			System.out.println("CATEGORY ID AFTER INSERTION " + category.getCid());
			session.flush();
			session.close();
		}

	public void deletecategory(int cid) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class, cid); //persistent
		session.delete(category);
		session.flush();
		session.close();
	}

	public Category getcategoryBycid(int cid) {
		Session session=sessionFactory.openSession();
       Category category=(Category)session.get(Category.class, cid);
        session.close();
        return category;
	}
}
