/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : fichapaciente

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2019-02-13 20:31:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `atendimento`
-- ----------------------------
DROP TABLE IF EXISTS `atendimento`;
CREATE TABLE `atendimento` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `IdPaciente` float DEFAULT NULL,
  `data_atendimento` date DEFAULT NULL,
  `especialidade` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_ATENDIMENTO_0` (`IdPaciente`),
  CONSTRAINT `FK_ATENDIMENTO_0` FOREIGN KEY (`IdPaciente`) REFERENCES `paciente` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of atendimento
-- ----------------------------
INSERT INTO `atendimento` VALUES ('3', '42', '2019-02-13', '15');

-- ----------------------------
-- Table structure for `especialidade`
-- ----------------------------
DROP TABLE IF EXISTS `especialidade`;
CREATE TABLE `especialidade` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of especialidade
-- ----------------------------
INSERT INTO `especialidade` VALUES ('1', 'Exames simples');
INSERT INTO `especialidade` VALUES ('2', 'Consultas em clinicas');
INSERT INTO `especialidade` VALUES ('3', 'Consultas hospitalares');
INSERT INTO `especialidade` VALUES ('4', 'Fisioterapia');
INSERT INTO `especialidade` VALUES ('5', 'Acupuntura');
INSERT INTO `especialidade` VALUES ('6', 'Cardiologia');
INSERT INTO `especialidade` VALUES ('7', 'Cirurgia geral');
INSERT INTO `especialidade` VALUES ('8', 'Clinica medica');
INSERT INTO `especialidade` VALUES ('9', 'Dermatologia');
INSERT INTO `especialidade` VALUES ('10', 'Endoscopia');
INSERT INTO `especialidade` VALUES ('11', 'Exames especiais');
INSERT INTO `especialidade` VALUES ('12', 'Exames simples');
INSERT INTO `especialidade` VALUES ('13', 'Pediatria');
INSERT INTO `especialidade` VALUES ('14', 'Fonoaudiologia');
INSERT INTO `especialidade` VALUES ('15', 'Cirurgia plastica');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `usuario` varchar(30) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------

-- ----------------------------
-- Table structure for `paciente`
-- ----------------------------
DROP TABLE IF EXISTS `paciente`;
CREATE TABLE `paciente` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `sexo` char(2) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nome_pai` varchar(100) DEFAULT NULL,
  `nome_mae` varchar(100) DEFAULT NULL,
  `plano` int(11) DEFAULT NULL,
  `numero_carteira` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of paciente
-- ----------------------------
INSERT INTO `paciente` VALUES ('42', 'Isabela oliveira', '', '1979-12-31', '123123123', 'F', '', '', '', '1', '64654646546');
INSERT INTO `paciente` VALUES ('43', 'Mario Campos', '', null, '5634563463', '', '', '', '', '2', '345622222');
INSERT INTO `paciente` VALUES ('44', 'Jose da Silva', null, null, '23535353', null, null, null, null, '3', '78658765867');

-- ----------------------------
-- Table structure for `plano_especialidade`
-- ----------------------------
DROP TABLE IF EXISTS `plano_especialidade`;
CREATE TABLE `plano_especialidade` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `especialidade_Id` float DEFAULT NULL,
  `plano_Id` float DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_PLANO_ESPECIALIDADE_0` (`especialidade_Id`),
  KEY `FK_PLANO_ESPECIALIDADE_1` (`plano_Id`),
  CONSTRAINT `FK_PLANO_ESPECIALIDADE_0` FOREIGN KEY (`especialidade_Id`) REFERENCES `especialidade` (`Id`),
  CONSTRAINT `FK_PLANO_ESPECIALIDADE_1` FOREIGN KEY (`plano_Id`) REFERENCES `plano_saude` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of plano_especialidade
-- ----------------------------
INSERT INTO `plano_especialidade` VALUES ('1', '1', '1');
INSERT INTO `plano_especialidade` VALUES ('2', '8', '1');
INSERT INTO `plano_especialidade` VALUES ('3', '3', '1');
INSERT INTO `plano_especialidade` VALUES ('4', '6', '2');
INSERT INTO `plano_especialidade` VALUES ('5', '7', '2');
INSERT INTO `plano_especialidade` VALUES ('6', '8', '2');
INSERT INTO `plano_especialidade` VALUES ('7', '9', '2');
INSERT INTO `plano_especialidade` VALUES ('8', '10', '2');
INSERT INTO `plano_especialidade` VALUES ('9', '1', '3');
INSERT INTO `plano_especialidade` VALUES ('10', '2', '3');
INSERT INTO `plano_especialidade` VALUES ('11', '3', '3');
INSERT INTO `plano_especialidade` VALUES ('12', '4', '3');
INSERT INTO `plano_especialidade` VALUES ('13', '5', '3');
INSERT INTO `plano_especialidade` VALUES ('14', '6', '3');
INSERT INTO `plano_especialidade` VALUES ('15', '7', '3');
INSERT INTO `plano_especialidade` VALUES ('16', '8', '3');
INSERT INTO `plano_especialidade` VALUES ('17', '9', '3');
INSERT INTO `plano_especialidade` VALUES ('18', '10', '3');
INSERT INTO `plano_especialidade` VALUES ('19', '11', '3');
INSERT INTO `plano_especialidade` VALUES ('20', '12', '3');
INSERT INTO `plano_especialidade` VALUES ('21', '13', '3');
INSERT INTO `plano_especialidade` VALUES ('22', '14', '3');
INSERT INTO `plano_especialidade` VALUES ('23', '15', '3');

-- ----------------------------
-- Table structure for `plano_saude`
-- ----------------------------
DROP TABLE IF EXISTS `plano_saude`;
CREATE TABLE `plano_saude` (
  `Id` float NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of plano_saude
-- ----------------------------
INSERT INTO `plano_saude` VALUES ('1', 'Básico');
INSERT INTO `plano_saude` VALUES ('2', 'Plus');
INSERT INTO `plano_saude` VALUES ('3', 'Vip');
