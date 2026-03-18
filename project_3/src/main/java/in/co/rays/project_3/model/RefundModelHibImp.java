package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.RefundDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DatabaseException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class RefundModelHibImp implements RefundModelInt{
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
			Criteria criteria = session.createCriteria(RefundDTO.class);
			if (pageSize > 0) {
				pageNo = ((pageNo - 1) * pageSize) + 1;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  staffMember list");
		} finally {
			session.close();
		}
		return list;
	}

	public long add(RefundDTO dto) throws ApplicationException, DuplicateRecordException {
		Session session = null;
		Transaction tx = null;
		long pk = 0;
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
			throw new ApplicationException("Exception in staffMember Add " + e.getMessage());
		} finally {
			session.close();
		}
		return pk;
	}

	public void delete(RefundDTO dto) throws ApplicationException {
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
			throw new ApplicationException("Exception in staffMember delete " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public void update(RefundDTO dto) throws ApplicationException, DatabaseException, DuplicateRecordException {
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
			throw new ApplicationException("Exception in staffMember update " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public List search(RefundDTO dto) throws ApplicationException {
		return search(dto, 0, 0);
	}

	public List search(RefundDTO dto, int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(RefundDTO.class);
			System.out.println(dto.getRefundDate()+"");
			if (dto != null) {
				if (dto.getId() != null) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getRefundCode() != null && dto.getRefundCode().length() > 0) {
					criteria.add(Restrictions.like("refundCode", dto.getRefundCode() + "%"));
				}
				if (dto.getRefundStatus() != null && dto.getRefundStatus().length() > 0) {
					criteria.add(Restrictions.like("refundStatus", dto.getRefundStatus() + "%"));
				}
			

			}

			// if page size is greater than zero the apply pagination
			if (pageSize > 0) {
				criteria.setFirstResult(((pageNo - 1) * pageSize));
				criteria.setMaxResults(pageSize);
			}

			list = criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception in staffMember search");
		} finally {
			session.close();
		}
       System.out.println("REfund ki list "+list.size());
		return list;
	}

	public RefundDTO findByPK(long pk) throws ApplicationException {
		Session session = null;
		RefundDTO dto = null;
		try {
			session = HibDataSource.getSession();

			dto = (RefundDTO) session.get(RefundDTO.class, pk);
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in getting staffMember by pk");
		} finally {
			session.close();
		}
		return dto;
	}
}
