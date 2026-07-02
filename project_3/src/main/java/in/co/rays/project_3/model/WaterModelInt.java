package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.WaterDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface WaterModelInt {
	
	public long add(WaterDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(WaterDTO dto)throws ApplicationException;
	public void update(WaterDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(WaterDTO dto)throws ApplicationException;
	public List search(WaterDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public WaterDTO findByPK(long pk)throws ApplicationException;
	public WaterDTO findByName(String name)throws ApplicationException;

}
