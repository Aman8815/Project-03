package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.RefundDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DatabaseException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface RefundModelInt {
	public long add(RefundDTO dto) throws ApplicationException, DuplicateRecordException;

	public void delete(RefundDTO dto) throws ApplicationException;

	public void update(RefundDTO dto) throws ApplicationException, DatabaseException, DuplicateRecordException;

	public List list() throws ApplicationException;

	public List list(int pageNo, int pageSize) throws ApplicationException;

	public List search(RefundDTO dto) throws ApplicationException;

	public List search(RefundDTO dto, int pageNo, int pageSize) throws ApplicationException;

	public RefundDTO findByPK(long pk) throws ApplicationException;

}
