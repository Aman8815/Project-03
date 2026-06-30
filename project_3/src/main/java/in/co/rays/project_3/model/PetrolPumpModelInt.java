package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.PetrolPumpDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface PetrolPumpModelInt {
	public long add(PetrolPumpDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(PetrolPumpDTO dto)throws ApplicationException;
	public void update(PetrolPumpDTO dto)throws ApplicationException,DuplicateRecordException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(PetrolPumpDTO dto)throws ApplicationException;
	public List search(PetrolPumpDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public PetrolPumpDTO findByPK(long pk)throws ApplicationException;
	public PetrolPumpDTO findByName(String name)throws ApplicationException;

}
