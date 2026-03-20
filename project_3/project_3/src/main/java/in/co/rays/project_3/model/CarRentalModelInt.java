package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.CarRentalDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface CarRentalModelInt {
	
	public long add(CarRentalDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(CarRentalDTO dto)throws ApplicationException;
	public void update(CarRentalDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(CarRentalDTO dto)throws ApplicationException;
	public List search(CarRentalDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public CarRentalDTO findByPK(long pk)throws ApplicationException;
	public CarRentalDTO findByName(String name)throws ApplicationException;

}
