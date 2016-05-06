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
import pe.com.tss.bean.Market;
import pe.com.tss.bean.Ramp;
import pe.com.tss.bean.RampArea;
import pe.com.tss.dao.MarketDao;
import pe.com.tss.dao.RampAreaDao;
import pe.com.tss.dao.RampDao;

public class RampMain {

	private static final Logger logger = Logger.getLogger(RampMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso TABLAS RAMPAREA - MARKET - RAMP]--------");

		long tiempoInicio = System.currentTimeMillis();

		try {

			RampDao rampDao = new RampDao();
			MarketDao marketDao = new MarketDao();
			RampAreaDao rampAreaDao = new RampAreaDao();

			FileInputStream file = new FileInputStream(new File("D:\\MasterData.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("Ramp");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));
			hoja.removeRow(hoja.getRow(1));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String rampareaname = "";
			String country = "";
			String state = "";
			String city = "";
			String marketname = "";
			String rampcode = "";
			String rampname = "";
			String zip = "";

			int indice = 0;

			int countRows = 0;
			// int idRampArea = 0;
			// int idMarket = 0;
			// int idRamp = 0;

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				indice = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (indice) {
					case 0:
						switch (cell.getCellType()) { // rampareaname
						case Cell.CELL_TYPE_NUMERIC:
							rampareaname = "";
							break;
						case Cell.CELL_TYPE_STRING:
							rampareaname = cell.getStringCellValue();
							break;
						}
						break;
					case 1:
						switch (cell.getCellType()) { // country
						case Cell.CELL_TYPE_NUMERIC:
							country = "";
							break;
						case Cell.CELL_TYPE_STRING:
							country = cell.getStringCellValue();
							break;
						}
						break;
					case 2:
						switch (cell.getCellType()) { // state
						case Cell.CELL_TYPE_NUMERIC:
							state = "";
							break;
						case Cell.CELL_TYPE_STRING:
							state = cell.getStringCellValue();
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
						switch (cell.getCellType()) { // marketname
						case Cell.CELL_TYPE_NUMERIC:
							marketname = "";
							break;
						case Cell.CELL_TYPE_STRING:
							marketname = cell.getStringCellValue();
							break;
						}
						break;
					case 5:
						switch (cell.getCellType()) { // rampcode
						case Cell.CELL_TYPE_NUMERIC:
							rampcode = "";
							break;
						case Cell.CELL_TYPE_STRING:
							rampcode = cell.getStringCellValue();
							break;
						}
						break;
					case 6:
						switch (cell.getCellType()) { // rampname
						case Cell.CELL_TYPE_NUMERIC:
							rampname = "";
							break;
						case Cell.CELL_TYPE_STRING:
							rampname = cell.getStringCellValue();
							break;
						}
						break;
					case 7:
						switch (cell.getCellType()) { // zip
						case Cell.CELL_TYPE_NUMERIC:
							zip = "";
							break;
						case Cell.CELL_TYPE_STRING:
							zip = cell.getStringCellValue();
							break;
						}
						break;
					default:
						break;
					}

					indice++;

				}
				countRows++;

				if (rampareaname.equals("") || country.equals("") || state.equals("") || city.equals("")
						|| marketname.equals("") || rampcode.equals("") || rampname.equals("")) {
					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");
				} else {

					RampArea ramparea = new RampArea();
					Market market = new Market();
					Ramp ramp = new Ramp();
					/*
					 * if (countryDao.exitsCountry(country) == true &&
					 * stateDao.existState(state) == true &&
					 * cityDao.existCity(city) == true) {
					 */
					if (rampAreaDao.exitsRampArea(rampareaname, country, state, city) == false) {
						// idRampArea++;
						// ramparea.setRampAreaId(idRampArea);
						ramparea.setCity(city);
						ramparea.setCountry(country);
						ramparea.setState(state);
						ramparea.setName(rampareaname);
						ramparea.setStatus("0");
						ramparea.setCreatedBy("BATCH");
						ramparea.setCreatedDate(new Date());
						ramparea.setUpdatedBy("BATCH");
						ramparea.setUpdatedDate(new Date());
						rampAreaDao.registrar(ramparea);
						logger.info("Se registraron los datos " + ramparea.toString());
					} else {
						ramparea = rampAreaDao.getRampArea(rampareaname, country, state, city);
					}

					if (marketDao.getMarket(marketname) == null) {
						// idMarket++;
						// market.setMarketId(idMarket);
						market.setName(marketname);
						market.setStatus("A");
						market.setRampAreaId(ramparea.getRampAreaId());
						market.setCreatedBy("CELTIC");
						market.setCreatedDate(new Date());
						market.setUpdatedBy("CELTIC");
						market.setUpdatedDate(new Date());
						marketDao.registrar(market);
						logger.info("Se registraron los datos " + market.toString());
					} else {
						market = marketDao.getMarket(marketname);
					}

					if (rampDao.getRamp(rampcode, rampname, zip) == null) {
						// idRamp++;
						// ramp.setRampId(idRamp);
						ramp.setMarketid(market.getMarketId());
						ramp.setName(rampname);
						ramp.setCode(rampcode);
						if (zip == "") {
							zip = "-";
						}
						ramp.setZipCode(zip);
						ramp.setStatus("0");
						ramp.setCreatedBy("BATCH");
						ramp.setCreatedDate(new Date());
						ramp.setUpdatedBy("BATCH");
						ramp.setUpdatedDate(new Date());
						rampDao.registrar(ramp);
						logger.info("Se registraron los datos " + ramp.toString());
					}

					/*
					 * } else {
					 * 
					 * }
					 */

				}

				rampareaname = "";
				country = "";
				state = "";
				city = "";
				marketname = "";
				rampcode = "";
				rampname = "";
				zip = "";

			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLAS RAMPAREA - MARKET - RAMP]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
