package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.InsuranceAppDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface InsuranceAppModelInt {
	
	public long add(InsuranceAppDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(InsuranceAppDTO dto)throws ApplicationException;
	public void update(InsuranceAppDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(InsuranceAppDTO dto)throws ApplicationException;
	public List search(InsuranceAppDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public InsuranceAppDTO findByPK(long pk)throws ApplicationException;
	public InsuranceAppDTO findByName(String name)throws ApplicationException;

}
