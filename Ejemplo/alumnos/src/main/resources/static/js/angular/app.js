angular.module('menu', [])
    .controller('formMA', function($scope, $http) {
        $scope.callBuscarMateria = function() {
                $http({
                    method: 'GET',
                    url: '/materia/obtener'
                }).then(function successCallback(response) {
                    var aux = response["data"];
                    var selectData = JSON.parse('[' + aux.join(',') + ']');
                    $scope.data = {
                        model: null,
                        availableOptions: selectData
                    };
                }, function errorCallback(response) {})
            },
            $scope.callCrearMateria = function() {
                var data = {
                    'nombre': $scope.nombreM,
                    'grupo': $scope.nombreG
                }
                $http({
                    method: 'POST',
                    url: '/materia/crear',
                    data: data
                }).then(function successCallback(response) {
                    swal("Cool", "Se guardó la materia correctamente.", "success");
                    $scope.materiaForm = {};
                }, function errorCallback(response) {
                    swal("Algo salió mal", "Hubo un error al guardar", "error");
                })
            }
        $scope.callCrearAlumno = function() {
            var data = {
                'nombre': $scope.nombreA,
                'boleta': $scope.nombreB,
                'materias': $scope.materiasM
            }
            $http({
                method: 'POST',
                url: '/alumno/crear',
                data: data
            }).then(function successCallback(response) {
                swal("Cool", "Se el alumno correctamente.", "success");
                $scope.alumnoForm = {};
            }, function errorCallback(response) {
                swal("Algo salió mal", "Hubo un error al guardar", "error");
            })
        }
    });