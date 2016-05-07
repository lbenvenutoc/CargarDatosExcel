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

import pe.com.tss.bean.Customer;
import pe.com.tss.bean.Office;
import pe.com.tss.bean.User;
import pe.com.tss.dao.CustomerDao;
import pe.com.tss.dao.OfficeDao;
import pe.com.tss.dao.UserDao;

public class CustomerMain {

	private static final Logger logger = Logger.getLogger(CustomerMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso TABLA CUSTOMER]--------");

		long tiempoInicio = System.currentTimeMillis();
		UserDao userDao = new UserDao();
		OfficeDao officeDao = new OfficeDao();
		CustomerDao customerDao = new CustomerDao();
		try {

			FileInputStream file = new FileInputStream(new File("E:\\MasterData.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("Customer");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String code = "";
			String name = "";
			String salesacconuntnamager = "";
			String office = "";
			String salesforcecode = "";

			int indice = 0;

			int countRows = 0;
			// int idCustomer = 0;

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				indice = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (indice) {
					case 0:
						switch (cell.getCellType()) { // code
						case Cell.CELL_TYPE_NUMERIC:
							code =""+(long)cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							code = cell.getStringCellValue();
							break;
						}
						break;
					case 1:
						switch (cell.getCellType()) { // name
						case Cell.CELL_TYPE_NUMERIC:
							name = "";
							break;
						case Cell.CELL_TYPE_STRING:
							name = cell.getStringCellValue();
							break;
						}
						break;
					case 2:
						switch (cell.getCellType()) { // salesacconuntnamager
						case Cell.CELL_TYPE_NUMERIC:
							salesacconuntnamager = "";
							break;
						case Cell.CELL_TYPE_STRING:
							salesacconuntnamager = cell.getStringCellValue();
							break;
						}
						break;
					case 3:
						switch (cell.getCellType()) { // office
						case Cell.CELL_TYPE_NUMERIC:
							office = "";
							break;
						case Cell.CELL_TYPE_STRING:
							office = cell.getStringCellValue();
							break;
						}
						break;
					case 4:
						switch (cell.getCellType()) { // salesforcecode
						case Cell.CELL_TYPE_NUMERIC:
							salesforcecode = "";
							break;
						case Cell.CELL_TYPE_STRING:
							salesforcecode = cell.getStringCellValue();
							break;
						}
						break;
					default:
						break;
					}

					indice++;

				}
				countRows++;

				if (code.equals("") || name.equals("") || salesacconuntnamager.equals("") || office.equals("")) {					
					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");
				} else {
					User u = userDao.getUser(salesacconuntnamager);
					Office o = officeDao.findByOfficeName(office);
					if (u != null && o != null) {
						// idCustomer++;
						Customer cliente = new Customer();
						// cliente.setCustomerid(idCustomer);
						cliente.setCustomername(name);
						cliente.setSalesaccountmanagerid(u.getUserid());
						// cliente.setSalesforceaccountid(Integer.parseInt(salesforcecode));
						cliente.setOfficeid(o.getOfficeid());
						cliente.setCode(code);
						cliente.setStatus("A");
						cliente.setCreatedby("CELTIC");
						cliente.setCreateddate(new Date());
						cliente.setUpdatedby("CELTIC");
						cliente.setUpdateddate(new Date());
						customerDao.registrar(cliente);
						logger.info("Se registraron los datos " + cliente.toString());
					} else {
						logger.info("User o Office no encontrado en fila " + countRows);
					}

				}

				code = "";
				name = "";
				salesacconuntnamager = "";
				office = "";
				salesforcecode = "";

			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLA CUSTOMER]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
