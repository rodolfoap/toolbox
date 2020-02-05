package net.sf.mpxj.junit.legacy;

import org.junit.Test;

import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.mspdi.MSPDIWriter;
import net.sf.mpxj.reader.UniversalProjectReader;
public class Planner2MSProject
{
   @Test public void testConversion1() throws Exception
   {
      UniversalProjectReader reader = new UniversalProjectReader();
      ProjectFile project = reader.read("/home/rodolfoap/project.planner");
      
      MSPDIWriter writer = new MSPDIWriter();
      writer.write(project, "/home/rodolfoap/project.msp"); 
   }
}
