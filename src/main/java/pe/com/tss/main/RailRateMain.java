package pe.com.tss.main;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pe.com.tss.bean.Customer;
import pe.com.tss.bean.DrayRate;
import pe.com.tss.bean.GeneralTable;
import pe.com.tss.bean.RailRate;
import pe.com.tss.bean.Ramp;
import pe.com.tss.bean.Vendor;
import pe.com.tss.dao.CustomerDao;
import pe.com.tss.dao.DrayRateDao;
import pe.com.tss.dao.GeneralTableDao;
import pe.com.tss.dao.RailRateDao;
import pe.com.tss.dao.RampDao;
import pe.com.tss.dao.VendorDao;

public class RailRateMain {

	private static final Logger logger = Logger.getLogger(RailRateMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso TABLA RAIL_RATE]--------");

		long tiempoInicio = System.currentTimeMillis();

		VendorDao vendorDao = new VendorDao();
		CustomerDao customerDao = new CustomerDao();
		GeneralTableDao tableDao = new GeneralTableDao();
		RampDao rampDao = new RampDao();
		RailRateDao railateDao = new RailRateDao();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		try {

			FileInputStream file = new FileInputStream(new File("D:\\MasterData_2.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("RailRate");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String originrampcode = "";
			String destinationrampcode = "";
			String vendorcode = "";
			String customercode = "";
			String equipmenttype = "";
			String equipmentsize = "";
			String ishazmat = "";
			String servicetype = "";
			String transitDays = "";
			String miles = "";
			String stcc = "";
			String rateType = "";
			String lineHaulcost = "";
			String fuel = "";
			String tariffNumber = "";
			String effectivdate = "";
			String expirationdate = "";
			String isimported = "";

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
						switch (cell.getCellType()) { // originrampcode
						case Cell.CELL_TYPE_NUMERIC:
							originrampcode = "";
							break;
						case Cell.CELL_TYPE_STRING:
							originrampcode = cell.getStringCellValue();
							break;
						}
						break;
					case 1:
						switch (cell.getCellType()) { // destinationrampcode
						case Cell.CELL_TYPE_NUMERIC:
							destinationrampcode = "";
							break;
						case Cell.CELL_TYPE_STRING:
							destinationrampcode = cell.getStringCellValue();
							break;
						}
						break;
					case 2:
						switch (cell.getCellType()) { // vendorcode
						case Cell.CELL_TYPE_NUMERIC:
							vendorcode = "";
							break;
						case Cell.CELL_TYPE_STRING:
							vendorcode = cell.getStringCellValue();
							break;
						}
						break;
					case 3:
						switch (cell.getCellType()) { // customercode
						case Cell.CELL_TYPE_NUMERIC:
							customercode = "";
							break;
						case Cell.CELL_TYPE_STRING:
							customercode = cell.getStringCellValue();
							break;
						}
						break;
					case 4:
						switch (cell.getCellType()) { // equipmenttype
						case Cell.CELL_TYPE_NUMERIC:
							equipmenttype = "";
							break;
						case Cell.CELL_TYPE_STRING:
							equipmenttype = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_BLANK:
							equipmenttype = "-";
							break;

						}
						break;
					case 5:
						switch (cell.getCellType()) { // equipmentsize
						case Cell.CELL_TYPE_NUMERIC:
							equipmentsize = "" + (int) cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							equipmentsize = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_BLANK:
							equipmentsize = "-";
							break;

						}
						break;
					case 6:
						switch (cell.getCellType()) { // ishazmat
						case Cell.CELL_TYPE_NUMERIC:
							ishazmat = "";
							break;
						case Cell.CELL_TYPE_STRING:
							ishazmat = cell.getStringCellValue();
							break;
						}
						break;
					case 7:
						switch (cell.getCellType()) { // servicetype
						case Cell.CELL_TYPE_NUMERIC:
							servicetype = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							servicetype = cell.getStringCellValue();
							break;
						}
						break;
					case 8:
						switch (cell.getCellType()) { // transitDays
						case Cell.CELL_TYPE_NUMERIC:
							transitDays = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							transitDays = cell.getStringCellValue();
							break;
						}
						break;
					case 9:
						switch (cell.getCellType()) { // miles
						case Cell.CELL_TYPE_NUMERIC:
							miles = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							miles = cell.getStringCellValue();
							break;
						}
						break;
					case 10:
						switch (cell.getCellType()) { // stcc
						case Cell.CELL_TYPE_NUMERIC:
							stcc = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							stcc = cell.getStringCellValue();
							break;
						}
						break;
					case 11:
						switch (cell.getCellType()) { // rateType
						case Cell.CELL_TYPE_NUMERIC:
							rateType = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							rateType = cell.getStringCellValue();
							break;
						}
						break;
					case 12:
						switch (cell.getCellType()) { // lineHaulcost
						case Cell.CELL_TYPE_NUMERIC:
							lineHaulcost = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							lineHaulcost = cell.getStringCellValue();
							break;
						}
						break;
					case 13:
						switch (cell.getCellType()) { // fuel
						case Cell.CELL_TYPE_NUMERIC:
							fuel = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							fuel = cell.getStringCellValue();
							break;
						}
						break;
					case 14:
						switch (cell.getCellType()) { // tariffNumber
						case Cell.CELL_TYPE_NUMERIC:
							tariffNumber = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							tariffNumber = cell.getStringCellValue();
							break;
						}
						break;
					case 15:
						switch (cell.getCellType()) { // effectivdate
						case Cell.CELL_TYPE_NUMERIC:
							effectivdate = sdf.format(cell.getDateCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							effectivdate = cell.getStringCellValue();
							break;
						}
						break;
					case 16:
						switch (cell.getCellType()) { // expirationdate
						case Cell.CELL_TYPE_NUMERIC:
							expirationdate = sdf.format(cell.getDateCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							expirationdate = cell.getStringCellValue();
							break;
						}
						break;
					case 17:
						switch (cell.getCellType()) { // isimported
						case Cell.CELL_TYPE_NUMERIC:
							isimported = "" + (int) cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							isimported = cell.getStringCellValue();
							break;
						}
						break;
					default:
						break;
					}

					indice++;

				}
				countRows++;
				
				/*
				logger.info("Fila " + countRows);
				logger.info("Datos originrampcode " + originrampcode);
				logger.info("Datos destinationrampcode " + destinationrampcode);
				logger.info("Datos vendorcode " + vendorcode);
				logger.info("Datos equipmenttype " + equipmenttype);
				logger.info("Datos equipmentsize " + equipmentsize);
				logger.info("Datos servicetype " + servicetype);
				logger.info("Datos effectivdate " + effectivdate);
				logger.info("Datos expirationdate " + expirationdate);
				logger.info("Datos stcc " + stcc);
				logger.info("Datos rateType " + rateType);
				logger.info("Datos lineHaulcost " + lineHaulcost);
				logger.info("Datos fuel " + fuel);
				logger.info("Datos tariffNumber " + tariffNumber);
				logger.info("Datos transitDays " + transitDays);
				*/

				if (originrampcode.equals("") || destinationrampcode.equals("") || vendorcode.equals("")
						|| servicetype.equals("") || effectivdate.equals("") || expirationdate.equals("")) {

					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");

				} else {

					RailRate railrate = new RailRate();
					Vendor v = vendorDao.getVendorName(vendorcode);
					Customer c = customerDao.getCustomerName(customercode);
					GeneralTable tablaEquipmentSize = tableDao.getGeneralTable(equipmentsize);
					GeneralTable tablaEquipmentType = tableDao.getGeneralTable(equipmenttype);
					Ramp rOrigin = rampDao.getRampCode(originrampcode);
					Ramp rDestino = rampDao.getRampCode(destinationrampcode);

					if (c != null) {
						railrate.setCustomerId(new BigDecimal(c.getCustomerid()));
					}
					if (v != null) {
						railrate.setVendorId(v.getVendorid());
					}

					if (rOrigin != null) {
						railrate.setOriginrampid(rOrigin.getRampId());
					}

					if (rDestino != null) {
						railrate.setDestinationrampid(rDestino.getRampId());
					}

					if (tablaEquipmentSize != null) {
						railrate.setEquipmentSize(tablaEquipmentSize.getValue());
					} else {
						railrate.setEquipmentSize(equipmentsize);
					}

					if (tablaEquipmentType != null) {
						railrate.setEquipmentType(tablaEquipmentType.getValue());
					} else {
						railrate.setEquipmentType(equipmenttype);
					}

					railrate.setServiceLevel(servicetype);
					railrate.setEffectiveDate(sdf.parse(effectivdate));
					railrate.setExpirationDate(sdf.parse(expirationdate));
					railrate.setIsHazMat(ishazmat);
					railrate.setTransitDays(new BigDecimal(transitDays));
					railrate.setMiles(new BigDecimal(miles));
					railrate.setStcc(stcc);
					railrate.setRateType(rateType);
					railrate.setLineHaulcost(new BigDecimal(lineHaulcost));
					railrate.setFuel(new BigDecimal(fuel));
					railrate.setTariffNumber(tariffNumber);
					railrate.setIsImported(isimported);
					railrate.setStatus("A");
					railrate.setCreatedBy("CELTIC");
					railrate.setCreatedDate(new Date());
					railrate.setUpdatedBy("CELTIC");
					railrate.setUpdatedDate(new Date());
					
					if (v != null) {
						railateDao.registrar(railrate);
						logger.info("Se registraron los datos " + railrate.toString());
					}

				}

				originrampcode = "";
				destinationrampcode = "";
				vendorcode = "";
				customercode = "";
				equipmenttype = "";
				equipmentsize = "";
				ishazmat = "";
				servicetype = "";
				transitDays = "";
				miles = "";
				stcc = "";
				rateType = "";
				lineHaulcost = "";
				fuel = "";
				tariffNumber = "";
				effectivdate = "";
				expirationdate = "";
				isimported = "";

			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLA RAIL_RATE]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
