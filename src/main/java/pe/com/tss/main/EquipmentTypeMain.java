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


public class EquipmentTypeMain {

	private static final Logger logger = Logger.getLogger(EquipmentTypeMain.class);

	public static void main(String[] args) {

		logger.info("[--------Inicio proceso GENERAL_TABLE  EquipmentType]--------");

		long tiempoInicio = System.currentTimeMillis();

		GeneralTableDao generalTableDao = new GeneralTableDao();

		try {

			FileInputStream file = new FileInputStream(new File("E:\\MasterData.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet hoja = workbook.getSheet("EquipmentType");

			// Quito las dos primeras filas del encabezado
			hoja.removeRow(hoja.getRow(0));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = hoja.iterator();

			String equipmenttype = "";
			
			int indice = 0;

			int countRows = 0;
			int idSort = 0;

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				indice = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (indice) {
					case 0:
						switch (cell.getCellType()) { // equipmenttype
						case Cell.CELL_TYPE_NUMERIC:
							equipmenttype = "";
							break;
						case Cell.CELL_TYPE_STRING:
							equipmenttype = cell.getStringCellValue();
							break;
						}
						break;					
					default:
						break;
					}

					indice++;

				}
				countRows++;

				if (equipmenttype.equals("")) {
					logger.info("Datos principales de la fila " + countRows + " nulos o en blanco");
				} else {
					
					GeneralTable tabla = new GeneralTable();
					
					if (generalTableDao.existGeneralTable(equipmenttype) == false) {						
						idSort++;
						tabla.setCode(equipmenttype);
						tabla.setValue(equipmenttype);
						tabla.setSortorder(idSort);
						tabla.setTablename("EquipmentType");
						tabla.setStatus("A");
						generalTableDao.registrar(tabla);
						logger.info("Se registraron los datos " + tabla.toString());
					}else{
						logger.info(tabla.toString()+" ya existe");
					}

				}

				equipmenttype = "";
				
			}

			logger.info("Tiempo TOTAL Proceso: " + (System.currentTimeMillis() - tiempoInicio) + " milisegundos ");
			logger.info("[--------Final proceso TABLA GENERAL_TABLE  EquipmentType]--------");
			file.close();
		} catch (Exception e) {
			logger.info("Fallo " + e.getMessage());
		}

	}

}
