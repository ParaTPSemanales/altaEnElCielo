[1mdiff --git a/src/bandera/Bandera.java b/src/bandera/Bandera.java[m
[1mindex 97684da..7c54418 100644[m
[1m--- a/src/bandera/Bandera.java[m
[1m+++ b/src/bandera/Bandera.java[m
[36m@@ -2,16 +2,16 @@[m [mpackage bandera;[m
 [m
 public class Bandera {[m
 [m
[31m-	private Escuela escuela;[m
 	private double largo;[m
 	private int costuras;[m
[32m+[m	[32mprivate double ultimoRetazo;[m
[32m+[m	[32mprivate double primerRetazo;[m
[32m+[m	[32mprivate double sobrante;[m
[32m+[m	[32mprivate double retazo;[m
 	[m
[31m-	public Escuela getEscuela() {[m
[31m-		return escuela;[m
[31m-	}[m
[31m-[m
[31m-	public void setEscuela(Escuela escuela) {[m
[31m-		this.escuela = escuela;[m
[32m+[m	[32mpublic Bandera (double largo) {[m
[32m+[m		[32mthis.primerRetazo=largo;[m
[32m+[m		[32mthis.ultimoRetazo=largo;[m
 	}[m
 	[m
 	public double getLargo() {[m
[36m@@ -30,7 +30,39 @@[m [mpublic class Bandera {[m
 		this.costuras = costuras;[m
 	}[m
 [m
[31m-	[m
[32m+[m	[32mpublic void alargarBandera(int aumento) {[m
[32m+[m		[32mlargo += aumento;[m
[32m+[m		[32multimoRetazo = aumento;[m
[32m+[m		[32mcosturas++;[m
[32m+[m		[32mretazo++;[m
[32m+[m	[32m}[m
[32m+[m	[32mpublic double getUltimoRetazo() {[m
[32m+[m		[32mreturn ultimoRetazo;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic double getPrimerRetazo() {[m
[32m+[m		[32mreturn primerRetazo;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic void setPrimerRetazo(double primerRetazo) {[m
[32m+[m		[32mthis.primerRetazo = primerRetazo;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic double getSobrante() {[m
[32m+[m		[32mreturn sobrante;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic void setSobrante(double sobrante) {[m
[32m+[m		[32mthis.sobrante = sobrante;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic double getRetazo() {[m
[32m+[m		[32mreturn retazo;[m
[32m+[m	[32m}[m
[32m+[m
[32m+[m	[32mpublic void setRetazo(double retazo) {[m
[32m+[m		[32mthis.retazo = retazo;[m
[32m+[m	[32m}[m
 	[m
 [m
 }[m
[1mdiff --git a/src/bandera/Carretel.java b/src/bandera/Carretel.java[m
[1mindex 1f78989..be3906e 100644[m
[1m--- a/src/bandera/Carretel.java[m
[1m+++ b/src/bandera/Carretel.java[m
[36m@@ -2,13 +2,13 @@[m [mpackage bandera;[m
 [m
 public class Carretel {[m
 [m
[31m-	private int largo;[m
[32m+[m	[32mprivate double largo;[m
 [m
 	public double getLargo() {[m
 		return largo;[m
 	}[m
 [m
[31m-	public void setLargo(int largo) {[m
[32m+[m	[32mpublic void setLargo(double largo) {[m
 		this.largo = largo;[m
 	}[m
 	[m
[36m@@ -16,4 +16,8 @@[m [mpublic class Carretel {[m
 		this.setLargo(0);[m
 	}[m
 	[m
[32m+[m	[32mpublic Carretel (double largo) {[m
[32m+[m		[32mthis.setLargo(largo);[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
 }[m
[1mdiff --git a/src/bandera/Ejercicio.java b/src/bandera/Ejercicio.java[m
[1mindex ea227f1..e9494af 100644[m
[1m--- a/src/bandera/Ejercicio.java[m
[1m+++ b/src/bandera/Ejercicio.java[m
[36m@@ -1,18 +1,26 @@[m
 package bandera;[m
 [m
[32m+[m[32mimport java.io.File;[m
[32m+[m[32mimport java.io.FileNotFoundException;[m
[32m+[m[32mimport java.io.FileWriter;[m
[32m+[m[32mimport java.io.IOException;[m
[32m+[m[32mimport java.io.PrintWriter;[m
 import java.util.Scanner;[m
 [m
 public class Ejercicio {[m
 [m
[31m-	public static void main(String[] args) {[m
[31m-	String miPath = "bandera.in";[m
[31m-	Scanner sc = new Scanner (miPath);[m
[31m-	Carretel carretel = new Carretel();[m
[31m-	carretel.setLargo(sc.nextInt());[m
[32m+[m	[32mpublic static void main(String[] args) throws FileNotFoundException {[m
[32m+[m	[32mString miPathEntrada = "Bandera.in";[m
[32m+[m	[32mScanner sc = new Scanner (new File(miPathEntrada));[m
[32m+[m	[32mCarretel carretel = new Carretel(sc.nextDouble());[m
 	Bandera [] escuelas = new Bandera [sc.nextInt()];[m
[31m-	[m
[31m-	[m
[32m+[m	[32mfor (int i = 0; i < escuelas.length; i++) {[m
[32m+[m		[32mescuelas[i] = new Bandera(sc.nextDouble());[m
[32m+[m		[32mcarretel.setLargo(carretel.getLargo()-escuelas[i].getPrimerRetazo());[m
[32m+[m	[32m}[m
 	sc.close();[m
 	}[m
[32m+[m[41m	[m
[32m+[m[41m	[m
 [m
 }[m
[1mdiff --git a/src/bandera/Escuela.java b/src/bandera/Escuela.java[m
[1mindex 681f6f6..f4333ac 100644[m
[1m--- a/src/bandera/Escuela.java[m
[1m+++ b/src/bandera/Escuela.java[m
[36m@@ -2,24 +2,12 @@[m [mpackage bandera;[m
 [m
 public class Escuela {[m
 [m
[31m-	private double primerRetazo;[m
[31m-	private double sobrante;[m
[31m-		[m
[31m-	public double getPrimerRetazo() {[m
[31m-		return primerRetazo;[m
[31m-	}[m
 	[m
[31m-	public void setPrimerRetazo(double primerRetazo) {[m
[31m-		this.primerRetazo = primerRetazo;[m
[31m-	}[m
 	[m
[31m-	public double getSobrante() {[m
[31m-		return sobrante;[m
[31m-	}[m
[32m+[m[41m		[m
[32m+[m
 	[m
[31m-	public void setSobrante(double sobrante) {[m
[31m-		this.sobrante = sobrante;[m
[31m-	}[m
[32m+[m
 	[m
 	[m
 	[m
