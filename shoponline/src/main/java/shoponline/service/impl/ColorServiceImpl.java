package shoponline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoponline.entity.Color;
import shoponline.repository.ColorRepository;
import shoponline.service.ColorService;
@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorRepository colorRepository;
	
	@Override
	public List<Color> getListColor() {
		return colorRepository.getListColor();
	}

}
