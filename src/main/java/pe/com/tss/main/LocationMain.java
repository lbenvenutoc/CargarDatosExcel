package pe.com.tss.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pe.com.tss.bean.City;
import pe.com.tss.bean.Country;
import pe.com.tss.bean.State;
import pe.com.tss.bean.Zip;
import pe.com.tss.dao.CityDao;
import pe.com.tss.dao.CountryDao;
import pe.com.tss.dao.StateDao;
import pe.com.tss.dao.ZipDao;

public class LocationMain {

	private static final Logger logger = Logger.getLogger(LocationMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso TABLAS COUNTRY - STATE - CITY - ZIP]--------");

		long tiempoInicio = System.currentTimeMillis();

		try {
			CountryDao countryDao = new CountryDao();
			StateDao stateDao = new StateDao();
			CityDao cityDao = new CityDao();
			ZipDao zipDao = new ZipDao();

			FileInputStream file = new FileInputStream(new File("D:\\MasterData.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("Location");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String country = "";
			String statecode = "";
			String statename = "";
			String city = "";
			String zipcode = "";

			int indice = 0;

			int countRows = 0;
			int idCountry=0;
			int idState=0;
			int idCity=0;
			int idZip=0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				indice = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (indice) {
					case 0:
						switch (cell.getCellType()) { // country
						case Cell.CELL_TYPE_NUMERIC:
							country = "";
							break;
						case Cell.CELL_TYPE_STRING:
							country = cell.getStringCellValue();
							break;
						}
						break;
					case 1:
						switch (cell.getCellType()) { // statecode
						case Cell.CELL_TYPE_NUMERIC:
							statecode = "";
							break;
						case Cell.CELL_TYPE_STRING:
							statecode = cell.getStringCellValue();
							break;
						}
						break;
					case 2:
						switch (cell.getCellType()) { // statename
						case Cell.CELL_TYPE_NUMERIC:
							statename = "";
							break;
						case Cell.CELL_TYPE_STRING:
							statename = cell.getStringCellValue();
							break;
						}
						break;
					case 3:
						switch (cell.getCellType()) { // city
						case Cell.CELL_TYPE_NUMERIC:
							city = "";
							break;
						case Cell.CELL_TYPE_STRING:
							city = cell.getStringCellValue();
							break;
						}
						break;
					case 4:
						switch (cell.getCellType()) { // zipcode
						case Cell.CELL_TYPE_NUMERIC:
							zipcode = "";
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
				

				if (country.equals("") || statecode.equals("") || statename.equals("") || city.equals("")) {
					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");
				} else {

					Country c = new Country();
					State state = new State();
					City objCity = new City();
					Zip zip = new Zip();

					if (countryDao.getCountry(country) == null) {
						idCountry++;
						c.setCountryid(idCountry);
						c.setName("");
						c.setAbbreviation(country);
						countryDao.registrar(c);
						logger.info("Se registraron los datos " + c.toString());
					} else {
						c = countryDao.getCountry(country);
					}

					if (stateDao.getState(statecode) == null) {
						idState++;
						state.setCountryId(c.getCountryid());
						state.setStateId(idState);
						state.setAbbreviation(statecode);
						state.setName(statename);
						stateDao.registrar(state);
						logger.info("Se registraron los datos " + state.toString());
					} else {
						state = stateDao.getState(statecode);
					}

					if (cityDao.getCity(city) == null) {
						idCity++;
						objCity.setCityid(idCity);
						objCity.setName(city);
						objCity.setStateid(state.getStateId());
						cityDao.registrar(objCity);
						logger.info("Se registraron los datos " + objCity.toString());

					} else {
						objCity = cityDao.getCity(city);
					}

					if (zipDao.getZip(zipcode) == null) {
						idZip++;
						zip.setZipid(idZip);
						zip.setCityid(objCity.getCityid());
						zip.setZipcode(zipcode);
						zipDao.registrar(zip);
						logger.info("Se registraron los datos " + zip.toString());
					}

				}

				country = "";
				statecode = "";
				statename = "";
				city = "";
				zipcode = "";

			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLAS COUNTRY - STATE - CITY - ZIP]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
