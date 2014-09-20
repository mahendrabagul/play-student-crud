package controllers;

import static play.data.Form.form;
import static play.libs.Json.toJson;

import java.util.List;

import models.Student;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

	public static Result index() {
		Form<Student> studentForm = form(Student.class);
		return ok(createAndList.render(studentForm));
	}

	public static Result saveStudent() {
		Student student = Form.form(Student.class).bindFromRequest().get();
		student.save();
		flash("success", "Student has been created");
		return redirect(routes.Application.index());
	}

	public static Result getStudents() {
		@SuppressWarnings("unchecked")
		List<Student> student = new Model.Finder(String.class, Student.class)
				.all();
		return ok(toJson(student));
	}

	public static Result deleteStudent(Long id) {
		Student.find.ref(id).delete();
		return redirect(routes.Application.index());
	}

	public static Result updateStudentGet(Long id) {
		Form<Student> studentForm = form(Student.class).fill(
				Student.find.byId(id));
		return ok(update.render(id, studentForm));
	}

	public static Result updateStudentPost(Long id) {
		Form<Student> studentForm = form(Student.class).bindFromRequest();
		if (studentForm.hasErrors()) {
			return badRequest(update.render(id, studentForm));
		}
		studentForm.get().update(id);
		flash("success", "Student " + studentForm.get().name
				+ " has been updated");
		return redirect(routes.Application.index());
	}
}


///@inputText(studentForm("gender"), '_label -> "Gender")
//							@inputText(studentForm("department"), '_label -> "Department") 

