package crackedcalc.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crackedcalc.pojo.Solution;
import crackedcalc.pojo.Values;

@WebServlet("/")
public class Servlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		getServletContext().getRequestDispatcher("/Page.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
		    BufferedReader reader = req.getReader();
		    while ((line = reader.readLine()) != null) {
		    	jb.append(line);
		    }
		} catch (IOException e) {
			throw new IOException("Failed to read request", e); 
		}
		Gson gson = new Gson();
		Values values = gson.fromJson(jb.toString(), Values.class);
		Double value1 = values.getValue();
		Double value2 = values.getOneMoreValue();
		Double result = null;
		String operation = values.getOperation();
		Solution solution = new Solution();
		if(operation.equals("Add")) {
			result = value1 + value2;
			solution.setValue(result.toString());
		}else if(operation.equals("Substract")) {
			result = value1 - value2;
			solution.setValue(result.toString());
		}else if(operation.equals("Multiply")) {
			result = value1 * value2;
			solution.setValue(result.toString());
		}else if(operation.equals("Divide"))  {
			if(value2 != 0) {
				result = value1 / value2;
				solution.setValue(result.toString());
			} else {
				solution.setValue("Can not divide by zero");
			}
		}
		String toResp = gson.toJson(solution);
		resp.setContentType("text/JSON");
		resp.getWriter().write(toResp);
	}
	
}

