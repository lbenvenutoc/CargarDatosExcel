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
import pe.com.tss.bean.Role;
import pe.com.tss.dao.RoleDao;

public class RoleMain {

	private static final Logger logger = Logger.getLogger(RoleMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso TABLA ROLE]--------");

		long tiempoInicio = System.currentTimeMillis();

		try {
			FileInputStream file = new FileInputStream(new File("D:\\MasterData.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("Role");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String rolename = "";
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
						switch (cell.getCellType()) { // ROLENAME
						case Cell.CELL_TYPE_NUMERIC:
							rolename = "";
							break;
						case Cell.CELL_TYPE_STRING:
							rolename = cell.getStringCellValue();
							break;
						}
						break;
					default:
						break;
					}

					indice++;

				}
				countRows++;

				RoleDao roleDao = new RoleDao();
				if (rolename.equals("")) {
					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");
				} else {
					Role role = new Role();
					role.setRoleid(countRows);
					role.setRolename(rolename);
					role.setCreatedby("CELTIC");					
					role.setCreateddate(new Date());
					role.setUpdatedby("CELTIC");
					role.setUpdateddate(new Date());
					roleDao.registrar(role);
					logger.info("Se registraron los datos " + role.toString());

				}

				rolename = "";

			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLA ROLE]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
