package shoponline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoponline.entity.Size;
import shoponline.repository.SizeRepository;
import shoponline.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService{

	@Autowired
	private SizeRepository sizeRepository;
	
	@Override
	public List<Size> getListSize() {
		return sizeRepository.getListSize();
	}

}
