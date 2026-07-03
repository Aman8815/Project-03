package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.SmartDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface SmartModelInt {
	public long add(SmartDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(SmartDTO dto)throws ApplicationException;
	public void update(SmartDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(SmartDTO dto)throws ApplicationException;
	public List search(SmartDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public SmartDTO findByPK(long pk)throws ApplicationException;
	public SmartDTO findByName(String name)throws ApplicationException;

}
