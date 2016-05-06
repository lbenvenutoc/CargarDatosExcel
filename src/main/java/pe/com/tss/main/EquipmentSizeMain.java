package pe.com.tss.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pe.com.tss.bean.GeneralTable;
import pe.com.tss.dao.GeneralTableDao;


public class EquipmentSizeMain {

	private static final Logger logger = Logger.getLogger(EquipmentSizeMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso GENERAL_TABLE  EquipmentSize]--------");

		long tiempoInicio = System.currentTimeMillis();

		GeneralTableDao generalTableDao = new GeneralTableDao();

		try {

			FileInputStream file = new FileInputStream(new File("D:\\MasterData.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("EquipmentSize");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String equipmentsize = "";
			
			int indice = 0;

			int countRows = 0;
			int idTable = 0;

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				indice = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (indice) {
					case 0:
						switch (cell.getCellType()) { // equipmentsize
						case Cell.CELL_TYPE_NUMERIC:
							equipmentsize = ""+(long)cell.getNumericCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							equipmentsize = cell.getStringCellValue();
							break;
						}
						break;					
					default:
						break;
					}

					indice++;

				}
				countRows++;

				if (equipmentsize.equals("")) {
					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");
				} else {
					
					GeneralTable tabla = new GeneralTable();
					
					if (generalTableDao.existGeneralTable(equipmentsize) == false) {						
						idTable=generalTableDao.getAll()+1;
						tabla.setGeneraltableid(idTable);
						tabla.setCode(equipmentsize);
						tabla.setValue(equipmentsize);
						tabla.setSortorder(idTable);
						tabla.setTablename("EquipmentSize");
						tabla.setStatus("A");
						generalTableDao.registrar(tabla);
						logger.info("Se registraron los datos " + tabla.toString());
					}else{
						logger.info(tabla.toString()+" ya existe");
					}

				}

				equipmentsize = "";
				
			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLA GENERAL_TABLE  EquipmentSize]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
