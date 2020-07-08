<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="eu.ensup.gestionscolairespringboot.domaine.Etudiant" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<meta charset="ISO-8859-1">
	<title>Profil</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="accueil">Gestion Etudiants</a>
	  	<div class="collapse navbar-collapse" id="navbarNavDropdown">
    		<ul class="navbar-nav">
    			<li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Menu �tudiant
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
			          <a class="dropdown-item" href="listeEtudiants">Lister �tudiants</a>
			          <a class="dropdown-item" href="getFormLireEtudiant">Info �tudiant</a>
			          <a class="dropdown-item" href="getFormSupprimerEtudiant">Supprimer un �tudiant</a>
			          <a class="dropdown-item" href="getFormModifierEtudiant">Modifier un �tudiant</a>
			          <a class="dropdown-item" href="getFormAjoutEtudiant">Ajouter un �tudiant</a>
			          <a class="dropdown-item" href="getFormAjoutEtudiantCours">Rajouter un �tudiant � un cours</a>
			          <a class="dropdown-item" href="getFormNoterEtudiant">Noter un �tudiant</a>
			          <a class="dropdown-item" href="listeMoyenne">Afficher la moyenne des �tudiants</a>
			        </div>
			    </li>
				<li class="nav-item active" style="padding-right: 10px">
		       		<a class="nav-link" href="/getFormLogin">D�connexion <span class="sr-only">(current)</span></a>
		   		</li>
    		</ul>
  		</div>
	</nav>
	<div class="jumbotron">
	  <h1>D�tail d'un �tudiant </h1>
	</div>
	
	<div class="container">		
		<table class="table table-striped table-dark">
		  	<thead>
			    <tr>
					<!-- <th scope="col">#</th> -->
					<th scope="col">Nom</th>
					<th scope="col">Prenom</th>
					<th scope="col">Mail</th>
					<th scope="col">T�l�phone</th>
					<th scope="col">Date de naissance</th>
					<th scope="col">Noter l'�tudiant</th>
			    </tr>
			</thead>
			<tbody>
				<c items="${etudiant}" var="etudiant">
					<tr>
						<!-- <th scope="row"><%-- out.println(i); --%></th>  -->
						<td>${etudiant.nom}</td>
						<td>${etudiant.prenom}</td>
						<td>${etudiant.mail}</td>
						<td>${etudiant.telephone}</td>
						<td>${etudiant.dateNaissance}</td>
						<td>
						<input type="text" style="margin:0; width:100%; box-shadow: 0;" placeholder="Donner une note" id="button-note1"/>
						<br>
						<br>
						<input type="button" onclick= "" value="Noter l'�tudiant" id="button-note2" class="btn-block"/>
						</td>
					</tr>
				</c>
		    </tbody>
		</table>
	</div>
</body>
</html>