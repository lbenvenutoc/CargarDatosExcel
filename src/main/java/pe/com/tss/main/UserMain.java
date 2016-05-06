package pe.com.tss.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pe.com.tss.bean.Office;
import pe.com.tss.bean.Role;
import pe.com.tss.bean.User;
import pe.com.tss.bean.UserOffice;
import pe.com.tss.bean.UserRole;
import pe.com.tss.dao.OfficeDao;
import pe.com.tss.dao.RoleDao;
import pe.com.tss.dao.UserDao;

public class UserMain {

	private static final Logger logger = Logger.getLogger(UserMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso TABLAS USER - USER_ROLE - USER_OFFICE]--------");

		long tiempoInicio = System.currentTimeMillis();

		try {

			RoleDao roleDao = new RoleDao();
			OfficeDao officeDao = new OfficeDao();
			UserDao userDao = new UserDao();

			FileInputStream file = new FileInputStream(new File("D:\\MasterData.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("User");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String username = "";
			String firstname = "";
			String lastname = "";
			String email = "";
			String title = "";
			String rolename = "";
			String officename = "";
			int indice = 0;

			int countRows = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				indice = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (indice) {
					case 0:
						switch (cell.getCellType()) { // username
						case Cell.CELL_TYPE_NUMERIC:
							username = "";
							break;
						case Cell.CELL_TYPE_STRING:
							username = cell.getStringCellValue();
							break;
						}
						break;
					case 1:
						switch (cell.getCellType()) { // firstname
						case Cell.CELL_TYPE_NUMERIC:
							firstname = "";
							break;
						case Cell.CELL_TYPE_STRING:
							firstname = cell.getStringCellValue();
							break;
						}
						break;
					case 2:
						switch (cell.getCellType()) { // lastname
						case Cell.CELL_TYPE_NUMERIC:
							lastname = "";
							break;
						case Cell.CELL_TYPE_STRING:
							lastname = cell.getStringCellValue();
							break;
						}
						break;
					case 3:
						switch (cell.getCellType()) { // title
						case Cell.CELL_TYPE_NUMERIC:
							title = "";
							break;
						case Cell.CELL_TYPE_STRING:
							title = cell.getStringCellValue();
							break;
						}
						break;
					case 4:
						switch (cell.getCellType()) { // email
						case Cell.CELL_TYPE_NUMERIC:
							email = "";
							break;
						case Cell.CELL_TYPE_STRING:
							email = cell.getStringCellValue();
							break;
						}
						break;
					case 5:
						switch (cell.getCellType()) { // rolename
						case Cell.CELL_TYPE_NUMERIC:
							rolename = "";
							break;
						case Cell.CELL_TYPE_STRING:
							rolename = cell.getStringCellValue();
							break;
						}
						break;
					case 6:
						switch (cell.getCellType()) { // officename
						case Cell.CELL_TYPE_NUMERIC:
							officename = "";
							break;
						case Cell.CELL_TYPE_STRING:
							officename = cell.getStringCellValue();
							break;
						}
						break;
					default:
						break;
					}

					indice++;

				}
				countRows++;

				if (username.equals("") || firstname.equals("") || lastname.equals("") || email.equals("")
						|| rolename.equals("") || officename.equals("") ) {
					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");
				} else {
					User user = new User();
					user.setUserid(countRows);
					user.setManagerid(countRows);
					user.setUsername(username);
					user.setFirtsname(firstname);
					user.setLastname(lastname);		
					user.setTitle(title);
					user.setPassword(username);
					user.setStatus("A");
					user.setCreatedby("CELTIC");
					user.setCreateddate(new Date());
					user.setUpdatedby("CELTIC");
					user.setUpdateddate(new Date());
					userDao.registrar(user);
					Role role = roleDao.findByRoleName(rolename);
					UserRole userrole = new UserRole();
					userrole.setUserid(user.getUserid());
					userrole.setRoleid(role.getRoleid());
					userrole.setCreatedby("CELTIC");
					userrole.setCreateddate(new Date());
					userrole.setUpdatedby("CELTIC");
					userrole.setUpdateddate(new Date());
					userDao.registrarUserRole(userrole);
					Office office = officeDao.findByOfficeName(officename);
					UserOffice useroffice = new UserOffice();
					useroffice.setOfficeid(office.getOfficeid());
					useroffice.setUserid(user.getUserid());
					useroffice.setCreatedby("CELTIC");
					useroffice.setCreateddate(new Date());
					useroffice.setUpdatedby("CELTIC");
					useroffice.setUpdateddate(new Date());
					userDao.registrarUserOffice(useroffice);
					logger.info("Se registraron los datos " + user.toString());

				}

				username = "";
				firstname = "";
				lastname = "";
				email = "";
				title = "";
				rolename = "";
				officename = "";

			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLAS USER - USER_ROLE - USER_OFFICE]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
