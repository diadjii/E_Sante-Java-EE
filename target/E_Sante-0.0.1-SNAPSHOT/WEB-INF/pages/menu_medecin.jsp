<nav id="menu"
	class="navbar navbar-toggleable-md navbar-light bg-faded navbar-right">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarNavDropdown"
		aria-controls="navbarNavDropdown" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class=" text-white navbar-brand" href="#">Navbar</a>
	<div class="collapse navbar-collapse" id="bar">
		<ul class="navbar-nav ">
			<li class="nav-item active"><a class="nav-link text-white"
				href="ajoutPatient">Nouveau Dossier</a></li>
			<li class="nav-item "><a class="nav-link text-white" href="#">Consultation</a></li>
			<li class="nav-item "><a class="nav-link text-white" href="#">Rendez-Vous</a></li>
			<li id="dropUser" class="nav-item dropdown "><a
				class="nav-link dropdown-toggle text-white"
				href="http://example.com" id="navbarDropdownMenuLink"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					${sessionScope.user.prenom} </a>
				<div class="dropdown-menu dropdown-menu-rigth"
					aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a> <a
						class="dropdown-item" href="#">Something else here</a>
					<div class="dropdown-divider"></div>
					<a id="logout" class="dropdown-item" href="">Deconnexion</a>
				</div></li>
		</ul>
	</div>
</nav>