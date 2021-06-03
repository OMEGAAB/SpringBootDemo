package com.in28minutes.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import com.in28minutes.springboot.web.model.Todo;
import com.in28minutes.springboot.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
    @Autowired
    TodoService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
    }

    @RequestMapping("/list-todos")
    public String showTodos(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
	}

    @RequestMapping("/add-todos")
    public String showAddTodosPage(ModelMap model) {
        model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "Add desc", new Date(), false));
        return "todos";
    }

    @RequestMapping("/delete-todos")
    public String deleteTodosPage(@RequestParam int id) {
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping("/update-todos")
    public String showUpdateTodosPage(@RequestParam int id, ModelMap model) {
        Todo todo = service.retrieveTodo(id);
        model.put("todo", todo);
        return "todos";
    }

    @RequestMapping(value = "/update-todos", method = RequestMethod.POST)
    public String updateTodosPage(@ModelAttribute("todo") @Valid Todo todo, ModelMap model, BindingResult result) {
        if(result.hasErrors())
            return "todos";
        todo.setUser(getLoggedInUserName(model));    
        service.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/add-todos", method = RequestMethod.POST)
    public String addTodos(@ModelAttribute("todo") @Valid Todo todo, ModelMap model,  BindingResult result) {
        if(result.hasErrors())
            return "todos";
        service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

}
