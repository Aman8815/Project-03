
package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.PatientDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class PatientModelHibImp implements PatientModelInt  {

	public long add(PatientDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		long pk = 0;
		PatientDTO existDto = findByName(dto.getDoctorName());
		if (existDto != null) {
			throw new DuplicateRecordException("Doctor Name already exist");
		}
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.save(dto);
			pk = dto.getId();
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in course Add " + e.getMessage());
		} finally {
			session.close();
		}
		return pk;
	}

	public void delete(PatientDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in course delete " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public void update(PatientDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.update(dto);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in course update " + e.getMessage());
		} finally {
			session.close();
		}

	}

	public PatientDTO findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		System.out.println("======"+pk);
		Session session = null;
		PatientDTO dto = null;
		try {
			session = HibDataSource.getSession();

			dto = (PatientDTO) session.get(PatientDTO.class, pk);
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in getting course by pk");
		} finally {
			session.close();
		}
		System.out.println("-------"+dto);
		return dto;
	}

	public PatientDTO findByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		PatientDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(PatientDTO.class);
			criteria.add(Restrictions.eq("doctorName", name));
			List list = criteria.list();
			if (list.size() > 0) {
				dto = (PatientDTO) list.get(0);
			}
		} catch (HibernateException e) {

			throw new ApplicationException("Exception in getting User by Login " + e.getMessage());

		} finally {
			session.close();
		}
		return dto;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(PatientDTO.class);
			if (pageSize > 0) {
				pageNo = ((pageNo - 1) * pageSize) + 1;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  course list");
		} finally {
			session.close();
		}
		return list;
	}

	public List search(PatientDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public List search(PatientDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		  Session session = null;
	        List list = null;
	        try {
	            session = HibDataSource.getSession();
	            Criteria criteria = session.createCriteria(PatientDTO.class);

	            if (dto.getId() > 0) {
	                criteria.add(Restrictions.eq("id", dto.getId()));
	            }
	            if (dto.getDoctorName() != null && dto.getDoctorName().length() > 0) {
	                criteria.add(Restrictions.like("doctorName", dto.getDoctorName() + "%"));
	            }
	            if (dto.getDisease() != null && dto.getDisease().length() > 0) {
	                criteria.add(Restrictions.eq("disease", dto.getDisease()
	                    ));
	            }
	            if (dto.getAdmissionDate() != null && dto.getAdmissionDate().getTime() > 0) {
	                criteria.add(Restrictions.like("admissionDate", dto.getAdmissionDate()));
	            }
	            

	            // if page size is greater than zero the apply pagination
	            if (pageSize > 0) {
	                criteria.setFirstResult(((pageNo - 1) * pageSize));
	                criteria.setMaxResults(pageSize);
	            }

	            list = criteria.list();
	        } catch (HibernateException e) {
	            
	            throw new ApplicationException("Exception in course search");
	        } finally {
	            session.close();
	        }

	       
	        return list;
	}







}
