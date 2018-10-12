angular.module('menu', []).controller('formMA', function($scope, $http) {
	$scope.callBuscarMateria = function() {
		$http({
			method : 'GET',
			url : '/materia/obtener'
		}).then(function successCallback(response) {
			var aux = response["data"];
			var selectData = JSON.parse('[' + aux.join(',') + ']');
			$scope.data = {
				model : null,
				availableOptions : selectData
			};
		}, function errorCallback(response) {
		})
	}, 
	$scope.callBuscarAlumno = function() {
		$http({
			method : 'GET',
			url : '/alumno/obtener'
		}).then(function successCallback(response) {
			var aux = response["data"];
			var selectData = JSON.parse('[' + aux.join(',') + ']');
			$scope.dataA = {
				model : null,
				availableOptions : selectData
			};
		}, function errorCallback(response) {
		})
	},
	
	$scope.callCrearMateria = function() {
		var data = {
			'nombre' : $scope.nombreM,
			'grupo' : $scope.nombreG
		}
		$http({
			method : 'POST',
			url : '/materia/crear',
			data : data
		}).then(function successCallback(response) {
			swal("Cool", "Se guardó la materia correctamente.", "success");
			$scope.materiaForm = {};
		}, function errorCallback(response) {
			swal("Algo salió mal", "Hubo un error al guardar", "error");
		})
	},
	$scope.callCrearAlumno = function() {
		var data = {
			'nombre' : $scope.nombreA,
			'boleta' : $scope.nombreB,
			'materias' : $scope.materiasM
		}
		$http({
			method : 'POST',
			url : '/alumno/crear',
			data : data
		}).then(function successCallback(response) {
			swal("Cool", "Se el alumno correctamente.", "success");
			$scope.alumnoForm = {};
		}, function errorCallback(response) {
			swal("Algo salió mal", "Hubo un error al guardar", "error");
		})
	},
	$scope.callEliminarAlumno = function() {
		var data = {
				'alumnos' : $scope.delAlumnos
			}
			$http({
				method : 'POST',
				url : '/alumno/eliminar',
				data : data
			}).then(function successCallback(response) {
				swal("Cool", "El alumno se elimino correctamente.", "success");
				$scope.alumnoForm = {};
			}, function errorCallback(response) {
				swal("Algo salió mal", "Hubo un error al eliminar", "error");
			})
	}
	,
	$scope.callModificarAlumno = function() {
		var data = {
				'alumnos' : $scope.modAlumnos,
				'boleta' : $scope.modBoleta
			}
			$http({
				method : 'POST',
				url : '/alumno/modificar',
				data : data
			}).then(function successCallback(response) {
				swal("Cool", "El alumno se actualizo correctamente.", "success");
				$scope.alumnoForm = {};
			}, function errorCallback(response) {
				swal("Algo salió mal", "Hubo un error al actualizar", "error");
			})
	}
});