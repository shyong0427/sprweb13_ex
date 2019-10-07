package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.DataDao;
import pack.model.GogekDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@RequestMapping("testdb")
	public ModelAndView listProcess() {
		ArrayList<GogekDto> list = dataDao.getDataAll();
		
		return new ModelAndView("list", "datas", list);
	}
}