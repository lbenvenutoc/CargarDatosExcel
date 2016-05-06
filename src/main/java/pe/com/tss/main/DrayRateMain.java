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
import pe.com.tss.bean.Ramp;
import pe.com.tss.bean.Vendor;
import pe.com.tss.dao.CustomerDao;
import pe.com.tss.dao.DrayRateDao;
import pe.com.tss.dao.GeneralTableDao;
import pe.com.tss.dao.RailRateDao;
import pe.com.tss.dao.RampDao;
import pe.com.tss.dao.VendorDao;

public class DrayRateMain {

	private static final Logger logger = Logger.getLogger(DrayRateMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso TABLA DRAY_RATE--------]");

		long tiempoInicio = System.currentTimeMillis();

		VendorDao vendorDao = new VendorDao();
		CustomerDao customerDao = new CustomerDao();
		GeneralTableDao tableDao = new GeneralTableDao();
		RampDao rampDao = new RampDao();
		DrayRateDao drayrateDao = new DrayRateDao();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		try {

			FileInputStream file = new FileInputStream(new File("D:\\MasterData_2.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("DrayRate");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String rampcode = "";
			String vendorcode = "";
			String customercode = "";
			String equipmenttype = "";
			String equipmentsize = "";
			String ishazmat = "";
			String servicetype = "";
			String segmenttype = "";
			String ratetype = "";
			String ratebasis = "";
			String rate = "";
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
						switch (cell.getCellType()) { // rampcode
						case Cell.CELL_TYPE_NUMERIC:
							rampcode = "";
							break;
						case Cell.CELL_TYPE_STRING:
							rampcode = cell.getStringCellValue();
							break;
						}
						break;
					case 1:
						switch (cell.getCellType()) { // vendorcode
						case Cell.CELL_TYPE_NUMERIC:
							vendorcode = "";
							break;
						case Cell.CELL_TYPE_STRING:
							vendorcode = cell.getStringCellValue();
							break;
						}
						break;
					case 2:
						switch (cell.getCellType()) { // customercode
						case Cell.CELL_TYPE_NUMERIC:
							customercode = "" + (int) cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							customercode = cell.getStringCellValue();
							break;
						}
						break;
					case 3:
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
					case 4:
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
					case 5:
						switch (cell.getCellType()) { // ishazmat
						case Cell.CELL_TYPE_NUMERIC:
							ishazmat = "";
							break;
						case Cell.CELL_TYPE_STRING:
							ishazmat = cell.getStringCellValue();
							break;

						}
						break;
					case 6:
						switch (cell.getCellType()) { // servicetype
						case Cell.CELL_TYPE_NUMERIC:
							servicetype = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							servicetype = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_BLANK:
							servicetype = "-";
							break;
						}
						break;
					case 7:
						switch (cell.getCellType()) { // segmenttype
						case Cell.CELL_TYPE_NUMERIC:
							segmenttype = "";
							break;
						case Cell.CELL_TYPE_STRING:
							segmenttype = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_BLANK:
							segmenttype = "-";
							break;
						}
						break;
					case 8:
						switch (cell.getCellType()) { // ratetype
						case Cell.CELL_TYPE_NUMERIC:
							ratetype = "";
							break;
						case Cell.CELL_TYPE_STRING:
							ratetype = cell.getStringCellValue();
							break;
						}
						break;
					case 9:
						switch (cell.getCellType()) { // ratebasis
						case Cell.CELL_TYPE_NUMERIC:
							ratebasis = "";
							break;
						case Cell.CELL_TYPE_STRING:
							ratebasis = cell.getStringCellValue();
							break;
						}
						break;
					case 10:
						switch (cell.getCellType()) { // rate
						case Cell.CELL_TYPE_NUMERIC:
							rate = "" + cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							rate = cell.getStringCellValue();
							break;
						}
						break;
					case 11:
						switch (cell.getCellType()) { // effectivdate
						case Cell.CELL_TYPE_NUMERIC:
							effectivdate = sdf.format(cell.getDateCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							effectivdate = cell.getStringCellValue();
							break;
						}
						break;
					case 12:
						switch (cell.getCellType()) { // expirationdate
						case Cell.CELL_TYPE_NUMERIC:
							expirationdate = sdf.format(cell.getDateCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							expirationdate = cell.getStringCellValue();
							break;
						}
						break;
					case 13:
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
				 * logger.info("Fila " + countRows); logger.info(
				 * "Datos rampcode " + rampcode); logger.info("Datos ratetype "
				 * + ratetype); logger.info("Datos ratebasis " + ratebasis);
				 * logger.info("Datos rate " + rate); logger.info(
				 * "Datos effectivdate " + effectivdate); logger.info(
				 * "Datos expirationdate " + expirationdate);
				 */

				if (rampcode.equals("") || ratetype.equals("") || ratebasis.equals("") || rate.equals("")
						|| effectivdate.equals("") || expirationdate.equals("") || servicetype.equals("")) {

					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");

				} else {
					DrayRate drayrate = new DrayRate();
					Vendor v = vendorDao.getVendorName(vendorcode);
					Customer c = customerDao.getCustomerName(customercode);
					Ramp r = rampDao.getRampCode(rampcode);
					GeneralTable tablaEquipmentSize = tableDao.getGeneralTable(equipmentsize);
					GeneralTable tablaEquipmentType = tableDao.getGeneralTable(equipmenttype);

					drayrate.setDrayServiceType(servicetype);
					drayrate.setEffectiveDate(sdf.parse(effectivdate));
					drayrate.setExpirationDate(sdf.parse(expirationdate));

					if (c != null) {
						drayrate.setCustomerId(new BigDecimal(c.getCustomerid()));
					}

					if (v != null) {
						drayrate.setVendorId(v.getVendorid());
					}

					if (r != null) {
						drayrate.setRampid(r.getRampId());
					} else {
						drayrate.setRampid(-1);
					}

					if (tablaEquipmentSize != null) {
						drayrate.setEquipmentSize(tablaEquipmentSize.getValue());
					} else {
						drayrate.setEquipmentSize(equipmentsize);
					}

					if (tablaEquipmentType != null) {
						drayrate.setEquipmentType(tablaEquipmentType.getValue());
					} else {
						drayrate.setEquipmentType(equipmenttype);
					}

					drayrate.setRate(new BigDecimal(rate));
					drayrate.setIsHazMat(ishazmat);
					drayrate.setDrayServiceType(servicetype);

					drayrate.setSegmentType(segmenttype);

					drayrate.setRateType(ratetype);
					drayrate.setRateBasis(ratebasis);
					drayrate.setStatus("A");
					drayrate.setCreatedBy("CELTIC");
					drayrate.setCreatedDate(new Date());
					drayrate.setUpdatedBy("CELTIC");
					drayrate.setUpdatedDate(new Date());
					drayrate.setIsImported(isimported); // CAMPO PENDIENTE EXCEL

					if (v != null) {
						drayrateDao.registrar(drayrate);
						logger.info("Se registraron los datos " + drayrate.toString());
					}

				}

				rampcode = "";
				vendorcode = "";
				customercode = "";
				equipmenttype = "";
				equipmentsize = "";
				ishazmat = "";
				servicetype = "";
				segmenttype = "";
				ratetype = "";
				ratebasis = "";
				rate = "";
				effectivdate = "";
				expirationdate = "";

			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLA DRAY_RATE--------]");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
