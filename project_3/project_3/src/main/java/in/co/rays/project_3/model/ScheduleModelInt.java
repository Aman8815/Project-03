package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.ScheduleDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface ScheduleModelInt {
	
	public long add(ScheduleDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(ScheduleDTO dto)throws ApplicationException;
	public void update(ScheduleDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(ScheduleDTO dto)throws ApplicationException;
	public List search(ScheduleDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public ScheduleDTO findByPK(long pk)throws ApplicationException;
	public ScheduleDTO findByName(String name)throws ApplicationException;

}
