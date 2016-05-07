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

import pe.com.tss.bean.Vendor;
import pe.com.tss.dao.VendorDao;

public class VendorMain {

	private static final Logger logger = Logger.getLogger(VendorMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso TABLA VENDOR]--------");

		long tiempoInicio = System.currentTimeMillis();

		VendorDao vendorDao = new VendorDao();

		try {

			FileInputStream file = new FileInputStream(new File("E:\\MasterData.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("Vendor");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String code = "";
			String name = "";
			String vendortype = "";

			int indice = 0;

			int countRows = 0;
			//int idVendor = 0;

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
							code = "";
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
						switch (cell.getCellType()) { // vendortype
						case Cell.CELL_TYPE_NUMERIC:
							vendortype = "";
							break;
						case Cell.CELL_TYPE_STRING:
							vendortype = cell.getStringCellValue();
							break;
						}
						break;
					default:
						break;
					}

					indice++;

				}
				countRows++;

				if (code.equals("") || name.equals("") || vendortype.equals("")) {
					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");
				} else {
					
					Vendor vendor = new Vendor();
					
					if (vendorDao.exitsVendor(code, name, vendortype) == false) {						
						//idVendor++;
						//vendor.setVendorid(idVendor);
						vendor.setName(name);
						vendor.setCode(code);
						vendor.setVendortype(vendortype);
						vendor.setStatus("A");
						vendor.setCreatedby("CELTIC");
						vendor.setCreateddate(new Date());
						vendor.setUpdatedby("CELTIC");
						vendor.setUpdateddate(new Date());
						vendorDao.registrar(vendor);
						logger.info("Se registraron los datos " + vendor.toString());
					}else{
						logger.info(vendor.toString()+" ya existe");
					}

				}

				code = "";
				name = "";
				vendortype = "";

			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLA VENDOR]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
