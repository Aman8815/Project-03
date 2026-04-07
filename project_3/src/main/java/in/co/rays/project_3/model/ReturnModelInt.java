package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.ReturnDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface ReturnModelInt {
	
	public long add(ReturnDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(ReturnDTO dto)throws ApplicationException;
	public void update(ReturnDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(ReturnDTO dto)throws ApplicationException;
	public List search(ReturnDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public ReturnDTO findByPK(long pk)throws ApplicationException;
	public ReturnDTO findByName(String name)throws ApplicationException;

}
