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
import pe.com.tss.dao.OfficeDao;

public class OfficeMain {

	private static final Logger logger = Logger.getLogger(OfficeMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso TABLA OFFICE]--------");

		long tiempoInicio = System.currentTimeMillis();

		try {
			FileInputStream file = new FileInputStream(new File("D:\\MasterData.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("Office");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String officename = "";
			String state = "";
			String city = "";
			String zipcode = "";
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
						switch (cell.getCellType()) { // COUNTRY
						case Cell.CELL_TYPE_NUMERIC:
							officename = "";
							break;
						case Cell.CELL_TYPE_STRING:
							officename = cell.getStringCellValue();
							// System.out.println("Oficaneme "+officename);
							break;
						}
						break;
					case 1:
						// STATE

						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							state = "";
							break;
						case Cell.CELL_TYPE_STRING:
							state = cell.getStringCellValue();
							break;
						}
						break;
					case 2:
						// CITY
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							city = "";
							break;
						case Cell.CELL_TYPE_STRING:
							city = cell.getStringCellValue();
							break;
						}
						break;
					case 3:
						// ZIPCODE
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							zipcode = String.valueOf(cell.getNumericCellValue()).replace(".0", "");
							break;
						case Cell.CELL_TYPE_STRING:
							zipcode = cell.getStringCellValue();
							break;
						}
						break;
					default:
						break;
					}

					indice++;

				}
				countRows++;

				OfficeDao officeDao = new OfficeDao();
				if (city.equals("") || state.equals("") || officename.equals("") || officename.equals("")) {
					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");
				} else {
					Office office = new Office();
					office.setCity(city);
					office.setCreatedby("CELTIC");
					office.setCreateddate(new Date());
					office.setOfficeid(countRows);
					office.setOfficename(officename);
					office.setState(state);
					office.setStatus("A");
					office.setUpdatedby("CELTIC");
					office.setUpdateddate(new Date());
					office.setZipcode(zipcode);
					officeDao.registrar(office);
					logger.info("Se registraron los datos " + office.toString());

				}

				officename = "";
				state = "";
				city = "";
				zipcode = "";

			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLA OFFICE]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
