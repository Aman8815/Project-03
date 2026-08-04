package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.FeeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface FeeModelInt {
	public long add(FeeDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(FeeDTO dto)throws ApplicationException;
	public void update(FeeDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(FeeDTO dto)throws ApplicationException;
	public List search(FeeDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public FeeDTO findByPK(long pk)throws ApplicationException;
	public FeeDTO findByName(String name)throws ApplicationException;

}
